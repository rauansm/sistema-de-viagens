package br.com.lis2b.auth.usuario.infra;

import br.com.lis2b.auth.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioJPARepository extends JpaRepository <Usuario, UUID>{

	Optional<Usuario> findByIdUsuario(UUID idUsuario);

}
