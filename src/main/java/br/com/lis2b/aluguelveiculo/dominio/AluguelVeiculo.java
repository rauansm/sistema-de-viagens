package br.com.lis2b.aluguelveiculo.dominio;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
public class AluguelVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idAluguelVeiculo", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String modeloVeiculo;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String locadora;
    private String localizacaoLocadora;
    private BigDecimal precoTotal;

}
