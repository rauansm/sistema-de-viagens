package br.com.lis2b.auth.security;

import br.com.lis2b.auth.credencial.application.service.CredencialService;
import br.com.lis2b.auth.credencial.domain.Credencial;
import br.com.lis2b.auth.security.domain.ValidaConteudoAuthorizationHeader;
import br.com.lis2b.auth.security.service.TokenService;
import br.com.lis2b.handler.APIException;
import br.com.lis2b.handler.ProblemType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
public class FiltroToken extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final CredencialService credencialService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("[inicio] Filtro - filtrando requisicao");
		String token = recuperaToken(request);
		autenticaCliente(token);
		log.info("[finaliza] Filtro - filtrando requisicao");
		filterChain.doFilter(request, response);
	}

	private void autenticaCliente(String token) {
		log.info("[inicio] autenticacaoCliente - utilizando token válido para autenticar o usuário");
		Credencial credencial = recuperaUsuario(token);
		var authenticationToken = new UsernamePasswordAuthenticationToken(credencial, null,
				credencial.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		log.info("[finaliza] autenticacaoCliente - utilizando token válido para autenticar o usuário");
	}

	private Credencial recuperaUsuario(String token) {
		var usuario = tokenService.getUsuario(token).orElseThrow(() -> APIException.build(HttpStatus.FORBIDDEN, "O Token enviado está inválido. Tente novamente.", ProblemType.ACESSO_NEGADO));
		return credencialService.buscaCredencialPorUsuario(usuario);
	}

	private String recuperaToken(HttpServletRequest requestOpt) {
		log.info("[inicio] recuperaToken - extraindo o token dos cabecalhos da requisicao");
		var AuthorizationHeaderValueOpt = Optional.ofNullable(recuperaValorAuthorizationHeader(requestOpt));
		String AuthorizationHeaderValue = AuthorizationHeaderValueOpt.filter(new ValidaConteudoAuthorizationHeader())
				.orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!", ProblemType.ACESSO_NEGADO));
		log.info("[finaliza] recuperaToken - extraindo o token dos cabecalhos da requisicao");
		return AuthorizationHeaderValue.substring(7, AuthorizationHeaderValue.length());
	}

	private String recuperaValorAuthorizationHeader(HttpServletRequest request) {
		return Optional.ofNullable(request.getHeader("Authorization"))
				.orElseThrow(() -> APIException.build(HttpStatus.FORBIDDEN, "Token não está presente na requisição!", ProblemType.ACESSO_NEGADO));
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getRequestURI();
		return path.contains("/public/") || path.contains("/swagger-ui/");
	}
}
