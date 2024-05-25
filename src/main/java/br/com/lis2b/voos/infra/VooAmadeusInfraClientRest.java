package br.com.lis2b.voos.infra;

import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import br.com.lis2b.voos.application.service.VooClientRest;
import br.com.lis2b.voos.dominio.FlightOfferResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class VooAmadeusInfraClientRest implements VooClientRest {
    private final VooAmadeusClientFeign vooClient;

    @Override
    public FlightOfferResponse buscaVoos(ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] VooAmadeusInfraClientRest - buscaVoos");
        try {
            FlightOfferResponse response = getFlightOfferResponse(cotacaoRequest);
            log.info("[finish] VooAmadeusInfraClientRest - buscaVoos");
            return response;
        } catch (Exception e) {
            log.error("[ERROR] VooAmadeusInfraClientRest - buscaVoos", e);
            return null;
        }
    }

    private FlightOfferResponse getFlightOfferResponse(ViagemCotacaoRequest cotacaoRequest) {
        return vooClient.buscaVoos(
                cotacaoRequest.getCodigoOrigem(),
                cotacaoRequest.getCodigoDestino(),
                cotacaoRequest.getDataIda(),
                cotacaoRequest.getDataVolta(),
                cotacaoRequest.getQuantidadePessoas(),
                false,
                "BRL",
                MAX_RESULTS);
    }
    private static final Integer MAX_RESULTS = 10;
}