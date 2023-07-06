package com.desafio.msdesafio.repository;

import com.desafio.msdesafio.entity.TipoCambio;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {

    List<TipoCambio> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String mondeaDestino);

    @Modifying
    @Transactional
    @Query("UPDATE TipoCambio tc SET tc.valorTipoCambio = ?1 WHERE tc.monedaDestino = ?3 and tc.monedaOrigen = ?2")
    void actualizar(BigDecimal valorTipoCambio, String monedaOrigen, String monedaDestino);
}
