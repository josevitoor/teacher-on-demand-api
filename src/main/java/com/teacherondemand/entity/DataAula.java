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

    @EmbeddedId
    private DataAulaId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idAula")
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;
}