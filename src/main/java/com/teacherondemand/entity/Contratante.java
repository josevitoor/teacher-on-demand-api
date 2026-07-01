package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contratante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contratante {

    @Id
    private Long idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}