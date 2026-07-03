package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pacote_aula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacoteAula {

    @Id
    private Long idTipoServico;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_tipo_servico")
    private TipoServico tipoServico;

    private Integer qtdAulas;
}