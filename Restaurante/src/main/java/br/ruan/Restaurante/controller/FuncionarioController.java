package br.ruan.Restaurante.controller;

import br.ruan.Restaurante.dto.FuncionarioRequestDTO;
import br.ruan.Restaurante.dto.FuncionarioResponseDTO;
import br.ruan.Restaurante.model.Funcionario;
import br.ruan.Restaurante.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<FuncionarioResponseDTO> getAll(){
        return funcionarioRepository.findAll().stream().map(FuncionarioResponseDTO :: new).toList();
    }

    @PostMapping
    public void addFuncionario(@RequestBody FuncionarioRequestDTO data){
        funcionarioRepository.save(new Funcionario(data));
    }

    @DeleteMapping("{id}")
    public void deleteFuncionario(@PathVariable Long id){
        for(Funcionario f : funcionarioRepository.findAll()){
            if (f.getId().equals(id)){
                funcionarioRepository.delete(f);
            }
        }
    }

    @PutMapping("{id}")
    public void editarFuncionario(@PathVariable Long id, @RequestBody FuncionarioRequestDTO data){
        Funcionario f = new Funcionario(data);
        f.setId(id);
        funcionarioRepository.save(f);
    }

}
