package com.desafio.msdesafio.request;

import java.math.BigDecimal;
import lombok.Data;
@Data
public class ValorTipoCambioRequest {

    private BigDecimal valorTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;

}
