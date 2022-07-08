package com.sofka.service;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.domain.CardDetail;

import java.util.List;
import java.util.Optional;

public interface ICardDetailService {
    public List<CardDetail> listCardDetail();

    public CardDetail saveCardDetail(CardDetail cardDetail);

    public Optional<CardDetail> findCardDetail(CardDetail cardDetail);
}
