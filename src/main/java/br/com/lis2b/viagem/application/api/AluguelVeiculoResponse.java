package br.com.lis2b.viagem.application.api;

import br.com.lis2b.aluguelveiculo.dominio.AluguelVeiculo;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class AluguelVeiculoResponse {

    private String modeloVeiculo;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String locadora;
    private String localizacaoLocadora;
    private BigDecimal precoTotal;

    public AluguelVeiculoResponse(AluguelVeiculo aluguelVeiculo) {
        this.modeloVeiculo = aluguelVeiculo.getModeloVeiculo();
        this.checkin = aluguelVeiculo.getCheckin();
        this.checkout = aluguelVeiculo.getCheckout();
        this.locadora = aluguelVeiculo.getLocadora();
        this.localizacaoLocadora = aluguelVeiculo.getLocalizacaoLocadora();
        this.precoTotal = aluguelVeiculo.getPrecoTotal();
    }

    public static List<AluguelVeiculoResponse> converte(List<AluguelVeiculo> alugueisVeiculos) {
        return alugueisVeiculos.stream()
            .map(AluguelVeiculoResponse::new)
            .collect(Collectors.toList());
    }
}
