package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    private Long idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String cpf;

    private LocalDate dataNascimento;

    private BigDecimal valorHoraAula;
}