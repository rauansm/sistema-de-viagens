package br.com.lis2b.aluguelveiculo.application.service;

import br.com.lis2b.aluguelveiculo.dominio.AluguelVeiculo;
import br.com.lis2b.aluguelveiculo.infra.AluguelVeiculoRepository;
import br.com.lis2b.viagem.application.api.AluguelVeiculoResponse;
import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class AluguelVeiculoApplicationService implements AluguelVeiculoService {
    private final AluguelVeiculoRepository aluguelVeiculoRepository;

    @Override
    public List<AluguelVeiculoResponse> buscarAlugueisVeiculos(ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] AluguelVeiculoApplicationService - buscarAlugueisVeiculos");
        List<AluguelVeiculo> alugueisVeiculos = aluguelVeiculoRepository.buscarAlugueisVeiculos(cotacaoRequest);
        log.info("[finish] AluguelVeiculoApplicationService - buscarAlugueisVeiculos");
        return AluguelVeiculoResponse.converte(alugueisVeiculos);
    }
}
