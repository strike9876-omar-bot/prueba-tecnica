package com.desafio.msdesafio.request;

import java.math.BigDecimal;
import lombok.Data;
@Data
public class TipoCambioRequest {

    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;

}
