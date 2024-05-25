package br.com.lis2b.hospedagem.dominio;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
public class Hospedagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idHospedagem", updatable = false, unique = true, nullable = false)
    private UUID idHospedagem;
    private String localizacao;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private String hotel;
    private BigDecimal precoTotal;

}
