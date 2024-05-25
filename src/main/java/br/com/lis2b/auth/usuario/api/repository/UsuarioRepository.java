package br.com.lis2b.auth.usuario.api.repository;


import br.com.lis2b.auth.usuario.domain.Usuario;

import java.util.UUID;

public interface UsuarioRepository {
	Usuario salva(Usuario usuario);
	Usuario buscaUsuarioPorId(UUID idUsuario);
}
