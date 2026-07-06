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

    @EmbeddedId
    private DiaSemanaId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idAulaMensal")
    @JoinColumn(name = "id_aula_mensal", nullable = false)
    private AulaMensal aulaMensal;
}