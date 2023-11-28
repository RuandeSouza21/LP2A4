package br.ruan.Restaurante.dto;

import br.ruan.Restaurante.model.Funcionario;

public record FuncionarioResponseDTO(Long id, String nome, String cpf) {
    public FuncionarioResponseDTO(Funcionario f){
        this(f.getId(),f.getNome(), f.getCpf());
    }
}
