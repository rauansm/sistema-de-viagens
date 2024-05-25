package br.com.lis2b.hospedagem.application.service;

import br.com.lis2b.hospedagem.dominio.Hospedagem;
import br.com.lis2b.hospedagem.infra.HospedagemRepository;
import br.com.lis2b.viagem.application.api.HospedagemResponse;
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
public class HospedagemApplicationService implements HospedagemService {
    private final HospedagemRepository hospedagemRepository;
    @Override
    public List<HospedagemResponse> buscarHospedagens(ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] HospedagemApplicationService - buscarHospedagens");
        List<Hospedagem> hospedagens = hospedagemRepository.buscarHospedagens(cotacaoRequest);
        log.info("[finish] HospedagemApplicationService - buscarHospedagens");
        return HospedagemResponse.converte(hospedagens);
    }
}
