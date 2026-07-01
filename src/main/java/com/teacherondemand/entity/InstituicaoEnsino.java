package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instituicao_ensino")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstituicaoEnsino {

    @Id
    private Long idContratante;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idContratante")
    private Contratante contratante;

    private String cnpj;
}
