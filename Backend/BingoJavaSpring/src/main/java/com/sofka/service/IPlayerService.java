package com.sofka.service;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    public List<Player> listPlayer();

    public Player savePlayer(Player player);

    public Optional<Player> findPlayer(Player player);
}
