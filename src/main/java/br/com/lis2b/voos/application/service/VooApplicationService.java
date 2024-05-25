package br.com.lis2b.voos.application.service;

import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import br.com.lis2b.viagem.application.api.VooResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
@RequiredArgsConstructor
public class VooApplicationService implements VooService {

    @Override
    public List<VooResponse> buscarVoos(ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] VooApplicationService - buscarVoos");

        log.info("[finish] VooApplicationService - buscarVoos");
        return List.of();
    }
}
