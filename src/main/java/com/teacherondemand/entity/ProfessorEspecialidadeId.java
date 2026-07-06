package com.teacherondemand.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProfessorEspecialidadeId implements Serializable {

    @Column(name = "id_professor")
    private Long idProfessor;

    @Column(name = "especialidade", length = 100)
    private String especialidade;
}