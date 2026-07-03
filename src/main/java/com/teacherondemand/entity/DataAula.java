package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "data_aula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataAula {

    @Id
    @Column(name = "id_aula")
    private Long idAula;

    private LocalDate dataAula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;
}