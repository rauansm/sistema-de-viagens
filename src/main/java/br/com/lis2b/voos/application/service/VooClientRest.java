package br.com.lis2b.voos.application.service;

import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import br.com.lis2b.voos.dominio.FlightOfferResponse;

public interface VooClientRest {
    FlightOfferResponse buscaVoos(ViagemCotacaoRequest cotacaoRequest);
}
