package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoServico;

    @Column(length = 100, nullable = false)
    private String nome;
}