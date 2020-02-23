package com.estudo.pedro.API.controller;

import com.estudo.pedro.API.model.Console;
import com.estudo.pedro.API.model.Jogo;
import com.estudo.pedro.API.repository.ConsoleRepository;
import com.estudo.pedro.API.repository.JogoRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedro/API")
public class ConsoleGameController {

    @Autowired
    private ConsoleRepository consoleGameRepository;

    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping(path="/console/listaConsoles")
    public final ResponseEntity<?> listaConsoles() {
        List<Console> consoles = consoleGameRepository.findAll();

        return ResponseEntity.ok().body(consoles);
    }

    @GetMapping(path="/jogo/listaJogos")
    public final ResponseEntity<?> listaJogos(@Param("nameJogo") String nameJogo) {
        System.out.println(nameJogo);
        try {
            if (nameJogo != null) {
                List<Jogo> jogo = jogoRepository.findByTituloContaining(nameJogo);
                return ResponseEntity.ok().body(jogo);
            } else {
                List<Jogo> jogos = jogoRepository.findAll();
                return ResponseEntity.ok().body(jogos);
            }
        } catch(Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(e);
        }

    }

    @PostMapping(path = "/jogo/cadastroJogo", consumes = "application/json", produces = "application/json")

    public final ResponseEntity<?> cadastrarJogo(@RequestBody String request) {

        try {
            JsonElement elem = new JsonParser().parse(request);
            JsonObject obj = elem.getAsJsonObject();
            String nomeJogo = obj.get("jogoNome").toString().replaceAll("\"", "");
            Long valorJogo = obj.get("jogoValor").getAsLong();

            Jogo jogo = new Jogo(nomeJogo, valorJogo);
            jogoRepository.save(jogo);
            return ResponseEntity.status(201).body("Cadastrado com Sucesso!");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping(path = "/jogo/excluirJogo/{id}", consumes = "application/json", produces = "application/json")
    public final ResponseEntity<?> excluirJogo(@PathVariable Long id) {

        try {
            jogoRepository.deleteById(id);
            return ResponseEntity.ok().body("Registro deletado com Sucesso!");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping(path = "/jogo/alterarJogo/{id}", consumes = "application/json", produces = "application/json")
    public  final ResponseEntity<?> alterarJogo(@PathVariable Long id, @RequestBody String request) {
        try {
            JsonElement elem = new JsonParser().parse(request);
            JsonObject obj = elem.getAsJsonObject();
            String nomeJogo = obj.get("jogoNome").toString().replaceAll("\"", "");
            Optional<Jogo> jogo = jogoRepository.findById(id);
            // Long valorJogo = obj.get("jogoValor").getAsLong();

            jogoRepository.alterarJogo(id, nomeJogo);
            return ResponseEntity.ok().body(jogo);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(e);
        }
    }

}
