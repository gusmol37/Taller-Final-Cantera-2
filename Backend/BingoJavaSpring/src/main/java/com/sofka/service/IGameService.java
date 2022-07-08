package com.sofka.service;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.Game;

import java.util.List;
import java.util.Optional;

public interface IGameService {
    public List<Game> listGame();

    public Game save(Game game);

    public Optional<Game> findGame(Game game);
}