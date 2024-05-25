package br.com.lis2b.hospedagem.infra;

import br.com.lis2b.hospedagem.dominio.Hospedagem;
import br.com.lis2b.viagem.application.api.HospedagemResponse;
import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Log4j2
public class HospedagemInfraRepository implements HospedagemRepository {
    private final HospedagemJPARepository hospedagemJPARepository;

    @Override
    public List<Hospedagem> buscarHospedagens(ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] HospedagemInfraRepository - buscarHospedagens");
        List<Hospedagem> hospedagens = hospedagemJPARepository.findAll();
        log.info("[finish] HospedagemInfraRepository - buscarHospedagens");
        return hospedagens;
    }
}
