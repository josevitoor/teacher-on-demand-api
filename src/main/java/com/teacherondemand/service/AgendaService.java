package com.teacherondemand.service;

import com.teacherondemand.constant.StatusContratoEnum;
import com.teacherondemand.constant.StatusPagamentoEnum;
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

    public List<AgendaResponse> getAgendaUsuario(Long idUsuario) {
        return dataAulaService.getAgendaUsuario(idUsuario)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private AgendaResponse toResponse(DataAula dataAula) {
        Aula aula = dataAula.getAula();
        Contrato contrato = aula.getContrato();

        return AgendaResponse.builder()
                .idAula(aula.getIdAula())
                .dataAula(dataAula.getId().getDataAula())
                .horaInicio(aula.getHoraInicio())
                .horaFim(aula.getHoraFim())
                .endereco(aula.getEndereco())
                .professor(contrato.getProfessor().getUsuario().getNome())
                .contratante(contrato.getContratante().getUsuario().getNome())
                .servico(contrato.getServico().getDescricao())
                .statusContrato(contrato.getStatus())
                .idContrato(contrato.getIdContrato())
                .build();
    }

    @Transactional
    public Contrato criar(AgendamentoCreateRequest request) {
        Professor professor = professorService.getById(request.getIdProfessor());
        Contratante contratante = contratanteService.getById(request.getIdContratante());

        TipoServico tipoServico = TipoServico.builder()
                .nome(request.getTipoServico())
                .build();

        tipoServico = tipoServicoService.save(tipoServico);

        Servico servico = Servico.builder()
                .descricao(request.getDescricaoServico())
                .tipoServico(tipoServico)
                .build();

        servico = servicoService.save(servico);

        Contrato contrato = Contrato.builder()
                .professor(professor)
                .contratante(contratante)
                .servico(servico)
                .valorTotal(request.getValorTotal())
                .status(StatusContratoEnum.AGUARDANDO_APROVACAO)
                .build();

        contrato = contratoService.save(contrato);

        Aula aula = Aula.builder()
                .contrato(contrato)
                .endereco(request.getEndereco())
                .horaInicio(request.getHoraInicio())
                .horaFim(request.getHoraFim())
                .build();

        aula = aulaService.save(aula);

        for (LocalDate data : request.getDatas()) {
            DataAula dataAula = DataAula.builder()
                    .id(new DataAulaId(aula.getIdAula(), data))
                    .aula(aula)
                    .build();

            dataAulaService.save(dataAula);
        }

        Pagamento pagamento = Pagamento.builder()
                .contrato(contrato)
                .valor(request.getValorTotal())
                .data(LocalDate.now())
                .status(StatusPagamentoEnum.PENDENTE)
                .metodo(request.getMetodoPagamento())
                .build();

        pagamentoService.save(pagamento);

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