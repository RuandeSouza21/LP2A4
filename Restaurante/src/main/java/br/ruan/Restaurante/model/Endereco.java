package br.ruan.Restaurante.model;

import br.ruan.Restaurante.dto.EnderecoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enderecos")
@Entity(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeRua;
    @Column
    private String cidade;

    public Endereco(EnderecoRequestDTO e){
        this.nomeRua = e.nomeRua();
        this.cidade = e.cidade();
    }
}
