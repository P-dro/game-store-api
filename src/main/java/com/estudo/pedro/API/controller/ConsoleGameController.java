package com.estudo.pedro.API.controller;

import com.estudo.pedro.API.model.Console;
import com.estudo.pedro.API.model.Jogo;
import com.estudo.pedro.API.repository.ConsoleRepository;
import com.estudo.pedro.API.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedro/API")
public class ConsoleGameController {

    @Autowired
    private ConsoleRepository consoleGameRepository;

    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping(path="/listaConsoles")
    public final ResponseEntity<?> listaConsoles() {
        List<Console> consoles = consoleGameRepository.findAll();

        return ResponseEntity.ok().body(consoles);
    }

    @GetMapping(path="/listaJogos")
    public final ResponseEntity<?> listaJogos() {
        List<Jogo> jogos = jogoRepository.findAll();

        return ResponseEntity.ok().body(jogos);
    }

}
