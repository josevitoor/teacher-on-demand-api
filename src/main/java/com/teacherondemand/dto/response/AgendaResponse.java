package com.teacherondemand.dto.response;

import com.teacherondemand.constant.StatusContratoEnum;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendaResponse {

    private Long idContrato;
    private Long idAula;

    private String tipoAula;
    private String servico;

    private List<LocalDate> datas;

    private LocalDate dataVencimento;
    private List<String> diasSemana;

    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String endereco;

    private String professor;
    private String contratante;

    private StatusContratoEnum statusContrato;
}
