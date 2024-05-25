package br.com.lis2b.voos.application.service;

import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import br.com.lis2b.viagem.application.api.VooResponse;

import java.util.List;

public interface VooService {
    List<VooResponse> buscaVoos(ViagemCotacaoRequest cotacaoRequest);
}
