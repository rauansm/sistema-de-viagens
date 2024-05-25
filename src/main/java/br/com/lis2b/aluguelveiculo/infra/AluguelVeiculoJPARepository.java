package br.com.lis2b.aluguelveiculo.infra;

import br.com.lis2b.aluguelveiculo.dominio.AluguelVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AluguelVeiculoJPARepository extends JpaRepository<AluguelVeiculo, UUID> {
}
