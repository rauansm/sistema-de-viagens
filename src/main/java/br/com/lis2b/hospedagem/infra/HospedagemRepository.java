package br.com.lis2b.hospedagem.infra;

import br.com.lis2b.hospedagem.dominio.Hospedagem;
import br.com.lis2b.viagem.application.api.ViagemCotacaoRequest;

import java.util.List;

public interface HospedagemRepository {
    List<Hospedagem> buscarHospedagens(ViagemCotacaoRequest cotacaoRequest);
}
