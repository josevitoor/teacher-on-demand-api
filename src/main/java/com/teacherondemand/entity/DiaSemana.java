package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dia_semana")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaSemana {

    @Id
    @Column(name = "id_aula_mensal")
    private Long idAulaMensal;

    @Column(length = 30)
    private String diaSemana;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_aula_mensal", nullable = false)
    private AulaMensal aulaMensal;
}