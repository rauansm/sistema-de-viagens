package br.com.lis2b.auth.usuario.api;

import br.com.lis2b.auth.usuario.domain.Usuario;
import lombok.Value;

import java.util.UUID;
@Value
public class UsuarioCriadoResponse {
	
	private final UUID idUsuario;
	private final String email;
	
	public UsuarioCriadoResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.email = usuario.getEmail();
	}
}