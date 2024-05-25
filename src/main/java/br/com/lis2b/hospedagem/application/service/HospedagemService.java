package br.com.lis2b.hospedagem.application.service;

import br.com.lis2b.viagem.application.api.HospedagemResponse;
import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;

import java.util.List;

public interface HospedagemService {
    List<HospedagemResponse> buscarHospedagens(ViagemCotacaoRequest cotacaoRequest);
}
