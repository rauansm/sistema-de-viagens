package br.com.lis2b.viagem.application.service;

import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import br.com.lis2b.viagem.application.api.ViagemCotacaoResponse;

public interface ViagemService {
    ViagemCotacaoResponse gerarCotacao(ViagemCotacaoRequest cotacaoRequest);
}
