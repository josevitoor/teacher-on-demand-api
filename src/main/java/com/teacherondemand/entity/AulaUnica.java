package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aula_unica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AulaUnica {

    @Id
    private Long idTipoServico;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_tipo_servico")
    private TipoServico tipoServico;
}