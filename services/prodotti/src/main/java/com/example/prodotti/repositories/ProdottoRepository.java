package com.example.prodotti.repositories;

import com.example.prodotti.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
