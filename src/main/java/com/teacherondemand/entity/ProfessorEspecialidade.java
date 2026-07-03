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

    @Id
    @Column(name = "id_professor")
    private Long idProfessor;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;

    @Column(length = 100, nullable = false)
    private String especialidade;
}