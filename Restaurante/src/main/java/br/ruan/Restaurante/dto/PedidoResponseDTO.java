package br.ruan.Restaurante.dto;

import br.ruan.Restaurante.model.Cliente;
import br.ruan.Restaurante.model.Pedido;

import java.util.List;

public record PedidoResponseDTO(Long id, String titulo, ClienteResponseDTO cliente, FuncionarioResponseDTO funcionario, List<CardapioResponseDTO> pratos) {

    public PedidoResponseDTO(Pedido pedido){
        this(pedido.getId(), pedido.getTitulo(), new ClienteResponseDTO(pedido.getCliente()), new FuncionarioResponseDTO(pedido.getFuncionario()), pedido.getPratos().stream().map(CardapioResponseDTO::new).toList());
    }
}
