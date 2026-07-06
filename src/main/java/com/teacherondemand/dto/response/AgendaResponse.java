package com.teacherondemand.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendaResponse {

    private Long idAula;

    private LocalDate dataAula;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private String endereco;

    private String professor;

    private String contratante;

    private String servico;

    private String statusContrato;
}
