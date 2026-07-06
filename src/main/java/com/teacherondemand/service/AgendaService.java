package com.teacherondemand.service;

import com.teacherondemand.dto.response.AgendaResponse;
import com.teacherondemand.entity.Aula;
import com.teacherondemand.entity.Contrato;
import com.teacherondemand.entity.DataAula;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final DataAulaService dataAulaService;

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
                .build();
    }
}