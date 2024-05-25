package br.com.lis2b.viagem.application.api;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
public class ViagemCotacaoResponse {
    private String codigoOrigem;
    private String codigoDestino;
    private Integer quantidadePessoas;
    private LocalDate dataIda;
    private LocalDate dataVolta;

    private List<VooResponse> voos;
    private List<HospedagemResponse> hospedagens;
    private List<AluguelVeiculoResponse> alugueisVeiculos;

    public ViagemCotacaoResponse(ViagemCotacaoRequest cotacaoRequest, List<VooResponse> voos,
                                 List<HospedagemResponse> hospedagens, List<AluguelVeiculoResponse> alugueisVeiculos) {
        this.codigoOrigem = cotacaoRequest.getCodigoOrigem();
        this.codigoDestino = cotacaoRequest.getCodigoDestino();
        this.quantidadePessoas = cotacaoRequest.getQuantidadePessoas();
        this.dataIda = cotacaoRequest.getDataIda();
        this.dataVolta = cotacaoRequest.getDataVolta();
        this.voos = voos;
        this.hospedagens = hospedagens;
        this.alugueisVeiculos = alugueisVeiculos;
    }
}
