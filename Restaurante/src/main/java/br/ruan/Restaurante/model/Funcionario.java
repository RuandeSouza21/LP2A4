package br.ruan.Restaurante.model;

import br.ruan.Restaurante.dto.FuncionarioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionarios")
@Entity(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Funcionario(FuncionarioRequestDTO data){
        this.nome = data.nome();
        this.cpf = data.cpf();
    }
}
