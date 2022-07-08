package com.sofka.Util;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import org.springframework.http.HttpStatus;

public class Response {
    private Integer status;
    private Object data;

    public Response() {
        this.status = HttpStatus.OK.value();
        this.data = data;
    }
}
