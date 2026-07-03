package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;

    @Column(length = 250, nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_servico", nullable = false)
    private TipoServico tipoServico;
}