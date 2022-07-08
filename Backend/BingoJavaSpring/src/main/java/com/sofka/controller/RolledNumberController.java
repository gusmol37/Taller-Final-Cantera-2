package com.sofka.controller;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.RolledNumber;
import com.sofka.service.RolledNumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
// @CrossOrigin(origins = "http://localhost:4200")
public class RolledNumberController {

    /**
     * Métodos de petición para la table RolledNumber
     */

    @Autowired
    private RolledNumberService rolledNumberService;

    @GetMapping(path = "/rollednumber")
    public List<RolledNumber> listRolledNumber() {
        return rolledNumberService.listRolledNumber();
    }

    @GetMapping(path = "/rollednumber/{id}")
    public Optional<RolledNumber> getRolledNumber(RolledNumber rolledNumber) {
        return rolledNumberService.findRolledNumber(rolledNumber);
    }
}
