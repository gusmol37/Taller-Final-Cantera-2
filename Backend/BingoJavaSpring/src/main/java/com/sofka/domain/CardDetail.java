package com.sofka.domain;

/**
 * @author Gustavo Molina Batista <gusmol37@gmail.com>
 * @version 1.0.0 2022-07-03
 */

/**
 * Importar librerías
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Data
@Entity
@Table(name = "card_detail")

public class CardDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_detail_id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "line", nullable = false)
    private Integer line;

    @Column(name = "b")
    private Integer b;

    @Column(name = "i")
    private Integer i;

    @Column(name = "n")
    private Integer n;

    @Column(name = "g")
    private Integer g;

    @Column(name = "o")
    private Integer o;

    @Column(name = "is_b")
    private Boolean isB;

    @Column(name = "is_i")
    private Boolean isI;

    @Column(name = "is_n")
    private Boolean isN;

    @Column(name = "is_g")
    private Boolean isG;

    @Column(name = "is_o")
    private Boolean isO;
}
