package br.com.lis2b.auth.usuario.infra;

import br.com.lis2b.auth.usuario.api.repository.UsuarioRepository;
import br.com.lis2b.auth.usuario.domain.Usuario;
import br.com.lis2b.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuaiorInfraRepository implements UsuarioRepository {

	private final UsuarioJPARepository usuarioJPARepository; 

	@Override
	public Usuario salva(Usuario usuario) {
		log.info("[inicia] UsuaiorInfraRepository - salva");
		Usuario novoUsuario = usuarioJPARepository.save(usuario);
		log.info("[inicia] UsuaiorInfraRepository - salva");
		return novoUsuario;
	}

	@Override
	public Usuario buscaUsuarioPorId(UUID idUsuario) {
		log.info("[inicia] UsuaiorInfraRepository - buscaUsuarioPorId");
		Usuario usuario = usuarioJPARepository.findByIdUsuario(idUsuario)
				.orElseThrow(() -> APIException.entidadeNaoEncontrada("Usuario não encontrado!"));
		log.info("[finaliza] UsuaiorInfraRepository - buscaUsuarioPorId");
		return usuario;
	}
}
