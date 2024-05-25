package br.com.lis2b.viagem.application.api;

import br.com.lis2b.hospedagem.dominio.Hospedagem;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class HospedagemResponse {

    private String localizacao;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String hotel;
    private BigDecimal precoTotal;

    public HospedagemResponse(Hospedagem hospedagem) {
        this.localizacao = hospedagem.getLocalizacao();
        this.checkin = hospedagem.getCheckin();
        this.checkout = hospedagem.getCheckout();
        this.hotel = hospedagem.getHotel();
        this.precoTotal = hospedagem.getPrecoTotal();
    }

    public static List<HospedagemResponse> converte(List<Hospedagem> hospedagens) {
       return  hospedagens.stream()
                .map(HospedagemResponse::new)
                .collect(Collectors.toList());
    }
}
