package br.com.lis2b.auth.usuario.api;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Value
public class UsuarioNovoRequest {
	@Email
	private final String email;
	@Size(min = 6)
	private final String senha;
}
