package br.com.lis2b.viagem.application.api;

import br.com.lis2b.viagem.application.service.ViagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/viagem/cotacao")
@Log4j2
public class ViagemAPI {
    private final ViagemService viagemService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ViagemCotacaoResponse gerarCotacao(@RequestBody @Valid ViagemCotacaoRequest cotacaoRequest) {
        log.info("[start] ViagemAPI - buscarViagens");
        log.info("[cotacaoRequest] {} ", cotacaoRequest);
        var cotacao = viagemService.gerarCotacao(cotacaoRequest);
        log.info("[finish] ViagemAPI - buscarViagens");
        return cotacao;
    }
}
