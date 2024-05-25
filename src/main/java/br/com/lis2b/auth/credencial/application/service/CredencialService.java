package br.com.lis2b.auth.credencial.application.service;


import br.com.lis2b.auth.credencial.domain.Credencial;
import br.com.lis2b.auth.usuario.api.UsuarioNovoRequest;

import javax.validation.Valid;

public interface CredencialService {
	void criaNovaCredencial(@Valid UsuarioNovoRequest usuarioNovo);
	Credencial buscaCredencialPorUsuario(String usuario);
}
