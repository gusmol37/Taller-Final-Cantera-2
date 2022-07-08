package com.sofka.DTO;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import lombok.Data;

import java.io.Serializable;

@Data

public class RolledNumberDTO implements Serializable {
    private Integer rolledNumber;
    private Long gameId;
}
