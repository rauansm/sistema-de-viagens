package br.com.lis2b.voos.application.service;

import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import br.com.lis2b.viagem.application.api.VooResponse;
import br.com.lis2b.voos.dominio.FlightOfferResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
@RequiredArgsConstructor
public class VooApplicationService implements VooService {
    private final VooClientRest vooClientRest;

    @Override
    public List<VooResponse> buscaVoos(ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] VooApplicationService - buscaVoos");
        FlightOfferResponse voosBusca = vooClientRest.buscaVoos(cotacaoRequest);
        log.info("[finish] VooApplicationService - buscaVoos");
        return VooResponse.converte(voosBusca);
    }
}
