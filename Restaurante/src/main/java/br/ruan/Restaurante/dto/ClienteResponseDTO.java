package br.ruan.Restaurante.dto;

import br.ruan.Restaurante.model.Cliente;
import br.ruan.Restaurante.model.Endereco;

public record ClienteResponseDTO(Long id, String nome, Endereco endereco) {
    public ClienteResponseDTO(Cliente c){
        this(c.getId(), c.getNome(), c.getEndereco());
    }
}
