package com.teacherondemand.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorListResponse {

    private Long idProfessor;
    private String nome;
    private String email;
    private BigDecimal valorHoraAula;
    private List<String> especialidades;
}