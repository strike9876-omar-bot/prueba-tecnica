package com.desafio.msdesafio.service;

import com.desafio.msdesafio.request.TipoCambioRequest;
import com.desafio.msdesafio.entity.TipoCambio;
import com.desafio.msdesafio.exception.TipoCambioNotFoundException;
import com.desafio.msdesafio.repository.TipoCambioRepository;
import com.desafio.msdesafio.request.ValorTipoCambioRequest;
import com.desafio.msdesafio.response.TipoCambioResponse;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
public class TipoCambioService {

    @Autowired
    TipoCambioRepository tipoCambioRepository;

    public TipoCambioResponse aplicarTipoCambio(TipoCambioRequest request) {
        TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();

        TipoCambio tipoCambio = tipoCambioRepository
                .findByMonedaOrigenAndMonedaDestino(request.getMonedaOrigen(), request.getMonedaDestino()).stream().findFirst().orElse(null);

        if (Objects.isNull(tipoCambio)) {
            throw new TipoCambioNotFoundException("Tipo de cambio no encontrado");
        }

        BigDecimal montoConTipoCambio = request.getMonto().multiply(tipoCambio.getValorTipoCambio());

        tipoCambioResponse.setMonedaDestino(request.getMonedaDestino());
        tipoCambioResponse.setMonedaOrigen(request.getMonedaOrigen());
        tipoCambioResponse.setMonto(request.getMonto());
        tipoCambioResponse.setMontoConTipoCambio(montoConTipoCambio);
        tipoCambioResponse.setTipoCambio(tipoCambio.getValorTipoCambio());
        return tipoCambioResponse;
    }

    public void agregar() {
        TipoCambio valor1 = new TipoCambio();

        // valor1.setId(1L);
        valor1.setValorTipoCambio(BigDecimal.valueOf(3.5));
        valor1.setMonedaDestino("dolar");
        valor1.setMonedaOrigen("sol");
        tipoCambioRepository.save(valor1);

        TipoCambio valor2 = new TipoCambio();

        // valor1.setId(1L);
        valor2.setValorTipoCambio(BigDecimal.valueOf(4.5));
        valor2.setMonedaDestino("euro");
        valor2.setMonedaOrigen("sol");
        tipoCambioRepository.save(valor2);
    }

    @Transactional
    public void actualizarTipoCambio(ValorTipoCambioRequest request){
        
        tipoCambioRepository.actualizar(request.getValorTipoCambio(), request.getMonedaOrigen(), request.getMonedaDestino());

    }
}