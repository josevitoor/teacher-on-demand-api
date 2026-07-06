package com.teacherondemand.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DiaSemanaId implements Serializable {

    @Column(name = "id_aula_mensal")
    private Long idAulaMensal;

    @Column(name = "dia_semana", length = 30)
    private String diaSemana;
}