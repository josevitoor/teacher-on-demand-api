package com.teacherondemand.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    private LocalDate data;

    @Column(length = 50)
    private String status;

    @Column(length = 50)
    private String metodo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private Contrato contrato;
}
