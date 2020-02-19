package com.estudo.pedro.API.repository;

import com.estudo.pedro.API.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
