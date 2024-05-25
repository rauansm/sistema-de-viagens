package br.com.lis2b.auth.credencial.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "Perfil")
public class Perfil implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idNome;
	private String nome;

	@Override
	public String getAuthority() {
		return this.nome;
	}

	private static final long serialVersionUID = 1L;
}
