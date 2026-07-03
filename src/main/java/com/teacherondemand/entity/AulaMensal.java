package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "aula_mensal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AulaMensal {

    @Id
    private Long idTipoServico;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_tipo_servico")
    private TipoServico tipoServico;

    private LocalDate dataVencimento;
}