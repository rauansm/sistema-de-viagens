package br.com.lis2b.viagem.application.service;

import br.com.lis2b.aluguelveiculo.application.service.AluguelVeiculoService;
import br.com.lis2b.hospedagem.application.service.HospedagemService;
import br.com.lis2b.viagem.application.api.*;
import br.com.lis2b.voos.application.service.VooService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
@RequiredArgsConstructor
public class ViagemApplicationService implements ViagemService {

    private final VooService vooService;
    private final HospedagemService hospedagemService;
    private final AluguelVeiculoService aluguelVeiculoService;

    @Override
    public ViagemCotacaoResponse gerarCotacao(ViagemCotacaoRequest cotacaoRequest) {
        log.debug("[start] ViagemApplicationService - gerarCotacao");
        var voosFuture = buscarVoosAsync(cotacaoRequest);
        var hospedagensFuture = buscarHospedagensAsync(cotacaoRequest);
        var alugueisVeiculosFuture = buscarAlugueisVeiculosAsync(cotacaoRequest);

        CompletableFuture.allOf(voosFuture, hospedagensFuture, alugueisVeiculosFuture).join();
        log.debug("[finish] ViagemApplicationService - gerarCotacao");
        return new ViagemCotacaoResponse(cotacaoRequest, voosFuture.join(), hospedagensFuture.join(),
                alugueisVeiculosFuture.join());
    }

    @Async
    private CompletableFuture<List<VooResponse>> buscarVoosAsync(ViagemCotacaoRequest cotacaoRequest) {
        log.debug("[start] ViagemApplicationService - buscarVoosAsync");
        var voos = vooService.buscaVoos(cotacaoRequest);
        log.debug("[finish] ViagemApplicationService - buscarVoosAsync");
        return CompletableFuture.completedFuture(voos);
    }

    @Async
    private CompletableFuture<List<HospedagemResponse>> buscarHospedagensAsync(ViagemCotacaoRequest cotacaoRequest) {
        log.debug("[start] ViagemApplicationService - buscarHospedagensAsync");
        var hospedagens = hospedagemService.buscarHospedagens(cotacaoRequest);
        log.debug("[finish] ViagemApplicationService - buscarHospedagensAsync");
        return CompletableFuture.completedFuture(hospedagens);
    }

    @Async
    private CompletableFuture<List<AluguelVeiculoResponse>> buscarAlugueisVeiculosAsync(
            ViagemCotacaoRequest cotacaoRequest) {
        log.debug("[start] ViagemApplicationService - buscarAlugueisVeiculosAsync");
        var alugueisVeiculos = aluguelVeiculoService.buscarAlugueisVeiculos(cotacaoRequest);
        log.debug("[finish] ViagemApplicationService - buscarAlugueisVeiculosAsync");
        return CompletableFuture.completedFuture(alugueisVeiculos);
    }
}
