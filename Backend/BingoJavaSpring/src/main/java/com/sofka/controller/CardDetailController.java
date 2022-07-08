package com.sofka.controller;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.CardDetail;
import com.sofka.domain.RolledNumber;
import com.sofka.service.CardDetailService;
import com.sofka.service.RolledNumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Controlador de la tabla CardDetail
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CardDetailController {
    @Autowired
    private CardDetailService cardDetailService;

    @GetMapping(path = "/carddetail")
    public List<CardDetail> listCardDetail() {
        return cardDetailService.listCardDetail();
    }

    @GetMapping(path = "/rollednumber/{rolled_number_id}")
    public Optional<CardDetail> findCardDetail(CardDetail cardDetail) {
        return cardDetailService.findCardDetail(cardDetail);
    }
}
