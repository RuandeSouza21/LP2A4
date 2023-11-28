package br.ruan.Restaurante.repository;

import br.ruan.Restaurante.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
