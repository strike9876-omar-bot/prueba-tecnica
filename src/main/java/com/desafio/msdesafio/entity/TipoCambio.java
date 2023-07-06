package com.desafio.msdesafio.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_cambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MONEDA_ORIGEN")
    private String monedaOrigen;

    @Column(name = "MONEDA_DESTINO")
    private String monedaDestino;

    @Column(name = "VALOR_TIPO_CAMBIO")
    private BigDecimal valorTipoCambio;

}
