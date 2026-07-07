package com.teacherondemand.dto.request;

import com.teacherondemand.constant.MetodoPagamentoEnum;
import com.teacherondemand.constant.TipoAulaEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class AgendamentoCreateRequest {

    private Long idProfessor;
    private Long idContratante;

    private String tipoServico;
    private TipoAulaEnum tipoAula;
    private String descricaoServico;

    private String endereco;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    private List<LocalDate> datas;

    private LocalDate dataVencimento;
    private List<String> diasSemana;
    private Integer qtdAulas;

    private BigDecimal valorTotal;
    private MetodoPagamentoEnum metodoPagamento;
}