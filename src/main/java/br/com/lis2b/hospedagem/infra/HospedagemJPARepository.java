package br.com.lis2b.hospedagem.infra;

import br.com.lis2b.hospedagem.dominio.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospedagemJPARepository extends JpaRepository<Hospedagem, UUID> {
}
