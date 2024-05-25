package br.com.lis2b.aluguelveiculo.infra;

import br.com.lis2b.aluguelveiculo.dominio.AluguelVeiculo;
import br.com.lis2b.viagem.application.api.AluguelVeiculoResponse;
import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Log4j2
public class AluguelVeiculoInfraRepository implements AluguelVeiculoRepository {
    private final AluguelVeiculoJPARepository aluguelVeiculoJPARepository;

    @Override
    public List<AluguelVeiculo> buscarAlugueisVeiculos(ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] AluguelVeiculoInfraRepository - buscarAlugueisVeiculos");
        List<AluguelVeiculo> alugueisVeiculos = aluguelVeiculoJPARepository.findAll();
        log.info("[finish] AluguelVeiculoInfraRepository - buscarAlugueisVeiculos");
        return alugueisVeiculos;
    }
}
