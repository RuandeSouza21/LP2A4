package br.ruan.Restaurante.controller;

import br.ruan.Restaurante.dto.ClienteRequestDTO;
import br.ruan.Restaurante.dto.ClienteResponseDTO;
import br.ruan.Restaurante.model.Cliente;
import br.ruan.Restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;
    @GetMapping
    public List<ClienteResponseDTO> getAll(){
        return clienteRepository.findAll().stream().map(ClienteResponseDTO :: new).toList();
    }

    @PostMapping
    public void addCliente(@RequestBody ClienteRequestDTO data){
        clienteRepository.save(new Cliente(data));
    }

    @DeleteMapping("{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO data){
        Cliente c = new Cliente(data);
        c.setId(id);
        clienteRepository.save(c);
    }

}
