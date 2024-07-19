package com.example.payment.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double totalAmount;
    @Column
    @Enumerated(EnumType.STRING)
    private MetodoDiPagamento metodoDiPagamento;
    @Column
    private Long idCarrello;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

}
