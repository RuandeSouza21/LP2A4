package br.ruan.Restaurante.dto;

import java.util.List;

public record PedidoRequestDTO(String titulo, Long cliente, Long funcionario, List<Long> pratos) {
}
