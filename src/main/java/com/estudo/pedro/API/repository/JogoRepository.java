package com.estudo.pedro.API.repository;

import com.estudo.pedro.API.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {


    List<Jogo> findByTituloContaining(String nameJogo);

    //@Query(value = "UPDATE Jogo SET Jogo.titulo = :nomeJogo WHERE Jogo.id = :id")
    @Query( value = "update jogo set jogo.titulo = :nomeJogo where jogo.id = :id", nativeQuery = true)
    List<Jogo> alterarJogo(@Param("id") Long id, @Param("nomeJogo")String nomeJogo);

}
