package com.sofka.controller;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.Player;
import com.sofka.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador de la tabla de Jugadores
 */
@Slf4j
@RestController
// @CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    /**
     * Método Get
     * 
     * @return Devuelve la lista de jugadores
     */
    @GetMapping(path = "/player")
    public List<Player> listPlayer() {
        return playerService.listPlayer();
    }

    /**
     * Método Get
     * 
     * @param player jugador
     * @return Devuelve la información de un jugador
     */
    @GetMapping(path = "/player/{id}")
    public Optional<Player> getPlayer(Player player) {
        return playerService.findPlayer(player);
    }

    /**
     * Método Post
     * 
     * @param player jugador
     * @return Devuelve la información del jugador creado
     */
    @PostMapping(path = "/player")
    public ResponseEntity<Player> createPlayer(Player player) {
        log.info("Jugador a crear: {}", player);
        playerService.savePlayer(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
}
