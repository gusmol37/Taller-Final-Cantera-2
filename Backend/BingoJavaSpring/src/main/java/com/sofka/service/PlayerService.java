package com.sofka.service;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.dao.PlayerDao;
import com.sofka.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private PlayerDao playerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Player> listPlayer() {
        return (List<Player>) playerDao.findAll();
    }

    @Override
    @Transactional
    public Player savePlayer(Player player) {
        return playerDao.save(player);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Player> findPlayer(Player player) {
        return playerDao.findById(player.getId());
    }
}
