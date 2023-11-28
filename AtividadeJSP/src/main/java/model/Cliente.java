package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private Date dataNasc;
    private String cpf;
    private String telefone;

    public Cliente(String nome, Date dataNasc, String cpf, String telefone) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
