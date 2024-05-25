package br.com.lis2b.auth.credencial.infra;


import br.com.lis2b.auth.credencial.domain.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredencialJPARepository extends JpaRepository<Credencial, String> {
	Optional<Credencial> findByUsuario(String usuario);
}
