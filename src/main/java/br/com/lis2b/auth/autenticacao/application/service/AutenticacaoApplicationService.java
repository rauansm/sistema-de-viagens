package br.com.lis2b.auth.autenticacao.application.service;

import br.com.lis2b.auth.autenticacao.domain.Token;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AutenticacaoApplicationService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
    Token reativaToken(String tokenExpirado);
}
