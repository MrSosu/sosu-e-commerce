package com.example.prodotti.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column
    private String descrizione;
    @Column
    @Check(constraints = "prezzo >= 0")
    private Double prezzo;
    @Column
    @Check(constraints = "quantita >= 0")
    private Integer quantita;
    @ManyToMany
    private List<Categoria> categoria;



}
