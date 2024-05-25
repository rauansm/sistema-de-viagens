package br.com.lis2b.auth.usuario.domain;

import br.com.lis2b.auth.usuario.api.UsuarioNovoRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idUsuario", updatable = false, unique = true, nullable = false)
	private UUID idUsuario;
	@Email
	@Column(unique = true)
	private String email;

	public Usuario(UsuarioNovoRequest usuarioNovo) {
		this.email = usuarioNovo.getEmail();
	}
}
