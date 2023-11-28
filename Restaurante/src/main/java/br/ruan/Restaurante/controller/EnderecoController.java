package br.ruan.Restaurante.controller;

import br.ruan.Restaurante.dto.EnderecoRequestDTO;
import br.ruan.Restaurante.dto.EnderecoResponseDTO;
import br.ruan.Restaurante.model.Endereco;
import br.ruan.Restaurante.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public List<EnderecoResponseDTO> getAll(){
        return enderecoRepository.findAll().stream().map(EnderecoResponseDTO :: new).toList();
    }

    @PostMapping
    public void addEndereco(@RequestBody EnderecoRequestDTO data){
        enderecoRepository.save(new Endereco(data));
    }

    @DeleteMapping("{id}")
    public void removeEndereco(@PathVariable Long id){
        enderecoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO data){
        Endereco e = new Endereco(data);
        e.setId(id);
        enderecoRepository.save(e);
    }
}
