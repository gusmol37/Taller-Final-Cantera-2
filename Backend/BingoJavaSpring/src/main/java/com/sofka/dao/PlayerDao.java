package com.sofka.dao;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerDao extends CrudRepository<Player, Long> {
}
