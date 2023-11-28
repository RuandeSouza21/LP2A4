package br.ruan.Restaurante.repository;

import br.ruan.Restaurante.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Prato, Long> {
}
