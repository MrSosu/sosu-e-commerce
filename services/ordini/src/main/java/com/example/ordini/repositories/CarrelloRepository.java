package com.example.ordini.repositories;

import com.example.ordini.entities.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {

}
