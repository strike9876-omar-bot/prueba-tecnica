package com.desafio.msdesafio.controller;

import com.desafio.msdesafio.request.TipoCambioRequest;
import com.desafio.msdesafio.request.ValorTipoCambioRequest;
import com.desafio.msdesafio.entity.TipoCambio;
import com.desafio.msdesafio.response.TipoCambioResponse;
import com.desafio.msdesafio.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;

    @PostMapping(value = "/tipo-cambio")
    public TipoCambioResponse aplicarTipoCambio(@RequestBody TipoCambioRequest request) {

        return tipoCambioService.aplicarTipoCambio(request);

    }

    @GetMapping(value = "/agregar")
    public void agregar() {

        tipoCambioService.agregar();

    }

    @PostMapping(value = "/actualizar")
    public void actualizar(@RequestBody ValorTipoCambioRequest request) {

        tipoCambioService.actualizarTipoCambio(request);

    }
}
