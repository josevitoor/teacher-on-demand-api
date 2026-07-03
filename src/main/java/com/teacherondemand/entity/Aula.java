package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "aula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAula;

    @Column(length = 100, nullable = false)
    private String endereco;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private Contrato contrato;
}