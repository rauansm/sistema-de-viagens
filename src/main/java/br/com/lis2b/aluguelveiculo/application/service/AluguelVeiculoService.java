package br.com.lis2b.aluguelveiculo.application.service;

import br.com.lis2b.viagem.application.api.AluguelVeiculoResponse;
import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;

import java.util.List;

public interface AluguelVeiculoService {
    List<AluguelVeiculoResponse> buscarAlugueisVeiculos(ViagemCotacaoRequest cotacaoRequest);
}
