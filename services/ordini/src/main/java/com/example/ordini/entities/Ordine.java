package com.example.ordini.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Carrello carrello;
    @Column
    private Long idProdotto;
    @Column
    private Integer quantita;

}
