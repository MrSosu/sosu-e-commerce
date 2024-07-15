package com.example.ordini.repositories;

import com.example.ordini.entities.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    @Query(value = "SELECT * FROM ordine WHERE id_carrello =:id_carrello", nativeQuery = true)
    List<Ordine> getOrdiniByCarrelloId(@Param("id_carrello") Long id_carrello);

}
