package br.com.lis2b.aluguelveiculo.infra;

import br.com.lis2b.aluguelveiculo.dominio.AluguelVeiculo;
import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;

import java.util.List;

public interface AluguelVeiculoRepository {
    List<AluguelVeiculo> buscarAlugueisVeiculos(ViagemCotacaoRequest cotacaoRequest);
}
