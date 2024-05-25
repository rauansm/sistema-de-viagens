package br.com.lis2b.viagem.application.api;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
public class HospedagemResponse {

    private String localizacao;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String hotel;
    private BigDecimal precoTotal;
}
