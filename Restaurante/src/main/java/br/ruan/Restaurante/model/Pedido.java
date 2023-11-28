package br.ruan.Restaurante.model;

import br.ruan.Restaurante.dto.PedidoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
@Entity(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_prato", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "prato_id"))
    private List<Prato> pratos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Pedido(String titulo, Cliente cliente, Funcionario funcionario, List<Prato> pratos) {
        this.titulo = titulo;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pratos = pratos;
    }
}
