package com.teacherondemand.service;

import com.teacherondemand.constant.StatusContratoEnum;
import com.teacherondemand.constant.StatusPagamentoEnum;
import com.teacherondemand.constant.TipoAulaEnum;
import com.teacherondemand.dto.request.AgendamentoCreateRequest;
import com.teacherondemand.dto.response.AgendaResponse;
import com.teacherondemand.entity.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final DataAulaService dataAulaService;
    private final ProfessorService professorService;
    private final ContratanteService contratanteService;
    private final ServicoService servicoService;
    private final ContratoService contratoService;
    private final AulaService aulaService;
    private final PagamentoService pagamentoService;
    private final TipoServicoService tipoServicoService;
    private final PacoteAulaService pacoteAulaService;
    private final AulaUnicaService aulaUnicaService;
    private final AulaMensalService aulaMensalService;
    private final DiaSemanaService diaSemanaService;

    public List<AgendaResponse> getAgendaUsuario(Long idUsuario) {
        return aulaService.getAgendaUsuario(idUsuario)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private AgendaResponse toResponse(Aula aula) {
        Contrato contrato = aula.getContrato();
        Servico servico = contrato.getServico();
        TipoServico tipoServico = servico.getTipoServico();

        Long idTipoServico = tipoServico.getIdTipoServico();

        String tipoAula = resolverTipoAula(idTipoServico);

        List<LocalDate> datas = dataAulaService.findByAula(aula.getIdAula())
                .stream()
                .map(data -> data.getId().getDataAula())
                .toList();

        LocalDate dataVencimento = null;
        List<String> diasSemana = List.of();

        if ("AULA_MENSAL".equals(tipoAula)) {
            AulaMensal aulaMensal = aulaMensalService.getById(idTipoServico);

            dataVencimento = aulaMensal.getDataVencimento();

            diasSemana = diaSemanaService.findByAulaMensal(idTipoServico)
                    .stream()
                    .map(dia -> dia.getId().getDiaSemana())
                    .toList();
        }

        return AgendaResponse.builder()
                .idContrato(contrato.getIdContrato())
                .idAula(aula.getIdAula())
                .tipoAula(tipoAula)
                .servico(servico.getDescricao())
                .datas(datas)
                .dataVencimento(dataVencimento)
                .diasSemana(diasSemana)
                .horaInicio(aula.getHoraInicio())
                .horaFim(aula.getHoraFim())
                .endereco(aula.getEndereco())
                .professor(contrato.getProfessor().getUsuario().getNome())
                .contratante(contrato.getContratante().getUsuario().getNome())
                .statusContrato(contrato.getStatus())
                .build();
    }

    private String resolverTipoAula(Long idTipoServico) {
        if (aulaUnicaService.exists(idTipoServico)) {
            return "AULA_UNICA";
        }

        if (pacoteAulaService.exists(idTipoServico)) {
            return "PACOTE_AULA";
        }

        if (aulaMensalService.exists(idTipoServico)) {
            return "AULA_MENSAL";
        }

        return "DESCONHECIDO";
    }

    @Transactional
    public Contrato criar(AgendamentoCreateRequest request) {
        Professor professor = professorService.getById(request.getIdProfessor());
        Contratante contratante = contratanteService.getById(request.getIdContratante());

        TipoServico tipoServico = tipoServicoService.save(
                TipoServico.builder()
                        .nome(request.getTipoServico())
                        .build()
        );

        if (TipoAulaEnum.AULA_UNICA == request.getTipoAula()) {
            aulaUnicaService.save(
                    AulaUnica.builder()
                            .tipoServico(tipoServico)
                            .build()
            );

            if (request.getDatas() == null || request.getDatas().size() != 1) {
                throw new RuntimeException("Aula única deve possuir exatamente uma data.");
            }
        }

        if (TipoAulaEnum.PACOTE_AULA == request.getTipoAula()) {
            pacoteAulaService.save(
                    PacoteAula.builder()
                            .tipoServico(tipoServico)
                            .qtdAulas(request.getQtdAulas())
                            .build()
            );

            if (request.getDatas() == null ||
                    request.getQtdAulas() == null ||
                    request.getDatas().size() != request.getQtdAulas()) {
                throw new RuntimeException("A quantidade de datas deve ser igual à quantidade de aulas do pacote.");
            }
        }

        if (TipoAulaEnum.AULA_MENSAL == request.getTipoAula()) {
            AulaMensal aulaMensal = aulaMensalService.save(
                    AulaMensal.builder()
                            .tipoServico(tipoServico)
                            .dataVencimento(request.getDataVencimento())
                            .build()
            );

            if (request.getDiasSemana() == null || request.getDiasSemana().isEmpty()) {
                throw new RuntimeException("Aula mensal deve possuir ao menos um dia da semana.");
            }

            for (String dia : request.getDiasSemana()) {
                DiaSemana diaSemana = DiaSemana.builder()
                        .id(new DiaSemanaId(aulaMensal.getIdTipoServico(), dia))
                        .aulaMensal(aulaMensal)
                        .build();

                diaSemanaService.save(diaSemana);
            }
        }

        Servico servico = servicoService.save(
                Servico.builder()
                        .descricao(request.getTipoServico())
                        .tipoServico(tipoServico)
                        .build()
        );

        Contrato contrato = contratoService.save(
                Contrato.builder()
                        .professor(professor)
                        .contratante(contratante)
                        .servico(servico)
                        .valorTotal(request.getValorTotal())
                        .status(StatusContratoEnum.AGUARDANDO_APROVACAO)
                        .build()
        );

        Aula aula = aulaService.save(
                Aula.builder()
                        .contrato(contrato)
                        .endereco(request.getEndereco())
                        .horaInicio(request.getHoraInicio())
                        .horaFim(request.getHoraFim())
                        .build()
        );

        if (TipoAulaEnum.AULA_MENSAL != request.getTipoAula()) {
            for (LocalDate data : request.getDatas()) {
                DataAula dataAula = DataAula.builder()
                        .id(new DataAulaId(aula.getIdAula(), data))
                        .aula(aula)
                        .build();

                dataAulaService.save(dataAula);
            }
        }

        pagamentoService.save(
                Pagamento.builder()
                        .contrato(contrato)
                        .valor(request.getValorTotal())
                        .data(LocalDate.now())
                        .status(StatusPagamentoEnum.PENDENTE)
                        .metodo(request.getMetodoPagamento())
                        .build()
        );

        return contrato;
    }

    @Transactional
    public Contrato aprovar(Long idContrato) {
        Contrato contrato = contratoService.getById(idContrato);
        contrato.setStatus(StatusContratoEnum.AGENDADO);
        return contratoService.save(contrato);
    }

    @Transactional
    public Contrato recusar(Long idContrato) {
        Contrato contrato = contratoService.getById(idContrato);
        contrato.setStatus(StatusContratoEnum.RECUSADO);
        return contratoService.save(contrato);
    }
}