package com.teacherondemand.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;

    @Column(length = 50, nullable = false)
    private String tipo;

    @Column(length = 255, nullable = false)
    private String arquivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;
}