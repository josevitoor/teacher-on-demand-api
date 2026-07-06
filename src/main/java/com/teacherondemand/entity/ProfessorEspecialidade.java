package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professor_especialidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorEspecialidade {

    @EmbeddedId
    private ProfessorEspecialidadeId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idProfessor")
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;
}