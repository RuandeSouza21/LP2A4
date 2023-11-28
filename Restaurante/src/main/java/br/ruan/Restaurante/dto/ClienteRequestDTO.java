package br.ruan.Restaurante.dto;

import br.ruan.Restaurante.model.Endereco;

public record ClienteRequestDTO(String nome, Endereco endereco) {
}
