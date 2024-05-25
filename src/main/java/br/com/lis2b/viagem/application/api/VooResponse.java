package br.com.lis2b.viagem.application.api;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

    @Getter
    @ToString
    public class VooResponse {
        private List<ItinerarioResponse> itinerarios;
        private BigDecimal preco;



    @Getter
    @ToString
    public static class ItinerarioResponse {
        private String duracao;
        private List<SegmentoResponse> segmentos;

    }
    @Getter
    @ToString
    public static class SegmentoResponse {
        private String codigoAeroportoOrigem;
        private String codigoAeroportoDestino;
        private LocalDateTime decolagem;
        private String nomeCompanhiaAerea;
    }
}