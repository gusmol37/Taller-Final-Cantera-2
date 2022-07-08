package com.sofka.service;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.sofka.DTO.RolledNumberDTO;
import com.sofka.dao.CardDetailDao;
import com.sofka.dao.RolledNumberDao;
import com.sofka.domain.CardDetail;
import com.sofka.domain.RolledNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CardDetailService implements ICardDetailService {
    @Autowired
    private CardDetailDao cardDetailDao;

    @Override
    @Transactional(readOnly = true)
    public List<CardDetail> listCardDetail() {
        return (List<CardDetail>) cardDetailDao.findAll();
    }

    @Override
    @Transactional
    public CardDetail saveCardDetail(CardDetail cardDetail) {
        return cardDetailDao.save(cardDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CardDetail> findCardDetail(CardDetail cardDetail) {
        return cardDetailDao.findById(cardDetail.getId());
    }
}
