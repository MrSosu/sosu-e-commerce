package com.example.utenti.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String via;
    @Column(nullable = false)
    private Integer civico;
    @Column(nullable = false)
    private String cap;
    @Column
    private String comune;

}
