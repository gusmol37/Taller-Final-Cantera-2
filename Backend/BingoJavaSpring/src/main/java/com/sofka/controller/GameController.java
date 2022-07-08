package com.sofka.controller;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.Game;
import com.sofka.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador de la tabla de partidas.
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    /**
     * Testeo
     * 
     * @return Devuelve Hola Mundo
     */
    @GetMapping("/hello")
    public String hello() {
        log.info("Hola Mundo");
        return "Hola mundo";
    }

    @Autowired
    private GameService gameService;

    /**
     * Método Get para obtener el listado de partidas.
     * 
     * @return TODO revisar, no devuelve un Game, si no la conexión de las tablas.
     */
    @GetMapping(path = "/game")
    public List<Game> listGame() {
        return gameService.listGame();
    }

    @GetMapping(path = "/game/{id}")
    public Optional<Game> getGame(Game game) {
        return gameService.findGame(game);
    }

    /**
     * Crea un nuevo juego
     * 
     * @param game información del juego nuevo.
     * @return Devuelve la información del nuevo juego.
     */
    @PostMapping(path = "/game")
    public ResponseEntity<Game> createGame(Game game) {
        log.info("Contacto a crear: {}", game);
        gameService.save(game);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }
}
