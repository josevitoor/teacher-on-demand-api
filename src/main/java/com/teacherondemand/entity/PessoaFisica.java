package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa_fisica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaFisica {

    @Id
    private Long idContratante;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idContratante")
    private Contratante contratante;

    private String cpf;

    private LocalDate dataNascimento;
}