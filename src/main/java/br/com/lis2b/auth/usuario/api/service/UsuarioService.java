package br.com.lis2b.auth.usuario.api.service;


import br.com.lis2b.auth.usuario.api.UsuarioCriadoResponse;
import br.com.lis2b.auth.usuario.api.UsuarioNovoRequest;

import javax.validation.Valid;
import java.util.UUID;

public interface UsuarioService {

	UsuarioCriadoResponse criaNovoUsuario(@Valid UsuarioNovoRequest usuarioNovo);
	UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario);
}
