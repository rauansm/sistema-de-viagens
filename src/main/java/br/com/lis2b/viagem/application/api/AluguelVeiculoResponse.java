package br.com.lis2b.viagem.application.api;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
public class AluguelVeiculoResponse {

    private String modeloVeiculo;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String locadora;
    private String localizacaoLocadora;
    private BigDecimal precoTotal;
}
