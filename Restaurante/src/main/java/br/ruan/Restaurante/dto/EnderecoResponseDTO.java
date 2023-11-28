package br.ruan.Restaurante.dto;

import br.ruan.Restaurante.model.Endereco;

public record EnderecoResponseDTO(Long id, String nomeRua, String cidade) {
    public EnderecoResponseDTO(Endereco e){
        this(e.getId(), e.getNomeRua(), e.getCidade());
    }
}
