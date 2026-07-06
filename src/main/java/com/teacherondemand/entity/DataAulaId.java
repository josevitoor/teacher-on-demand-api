package com.teacherondemand.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DataAulaId implements Serializable {

    @Column(name = "id_aula")
    private Long idAula;

    @Column(name = "data_aula")
    private LocalDate dataAula;
}