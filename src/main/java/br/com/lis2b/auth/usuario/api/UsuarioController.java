package br.com.lis2b.auth.usuario.api;

import br.com.lis2b.auth.usuario.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {

	private final UsuarioService usuarioService;

	@Override
	public UsuarioCriadoResponse postNovoUsuario(@Valid UsuarioNovoRequest usuarioNovo) {
		log.info("[start] UsuarioController - postNovoUsuario");
		UsuarioCriadoResponse usuarioCriado = usuarioService.criaNovoUsuario(usuarioNovo);
		log.info("[finish] UsuarioController - postNovoUsuario");
		return usuarioCriado;
	}

	@Override
	public UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario) {
		log.info("[start] UsuarioController - buscaUsuarioPorId");
		log.info("[idUsuario] {}", idUsuario);
		UsuarioCriadoResponse buscaUsuario = usuarioService.buscaUsuarioPorId(idUsuario);
		log.info("[finish] UsuarioController - buscaUsuarioPorId");
		return buscaUsuario;
	}
}
