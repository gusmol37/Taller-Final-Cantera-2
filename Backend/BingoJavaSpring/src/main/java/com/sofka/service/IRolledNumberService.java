package com.sofka.service;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.DTO.RolledNumberDTO;
import com.sofka.domain.RolledNumber;

import java.util.List;
import java.util.Optional;

public interface IRolledNumberService {
    public List<RolledNumber> listRolledNumber();

    public RolledNumber saveRolledNumber(RolledNumber rolledNumber);

    public Optional<RolledNumber> findRolledNumber(RolledNumber rolledNumber);

    public List<RolledNumberDTO> rolledNumberByGame(Long gameId);
}
