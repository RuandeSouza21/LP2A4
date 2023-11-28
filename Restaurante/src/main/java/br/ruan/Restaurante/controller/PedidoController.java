package br.ruan.Restaurante.controller;

import br.ruan.Restaurante.dto.*;
import br.ruan.Restaurante.model.Cliente;
import br.ruan.Restaurante.model.Pedido;
import br.ruan.Restaurante.model.Prato;
import br.ruan.Restaurante.repository.CardapioRepository;
import br.ruan.Restaurante.repository.ClienteRepository;
import br.ruan.Restaurante.repository.FuncionarioRepository;
import br.ruan.Restaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CardapioRepository cardapioRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<PedidoResponseDTO> getAll(){
        return pedidoRepository.findAll().stream().map(PedidoResponseDTO :: new).toList();
    }

    @PostMapping
    public void addPedido(@RequestBody PedidoRequestDTO data){
        List<Prato> p = new ArrayList<>();
        for (Long id: data.pratos()){
            p.add(cardapioRepository.findById(id).get());
        }
        pedidoRepository.save(new Pedido(data.titulo(), clienteRepository.findById(data.cliente()).get(), funcionarioRepository.findById(data.funcionario()).get(), p));
    }

    @DeleteMapping("{id}")
    public void deletePedido(@PathVariable Long id){
        pedidoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updatePedido(@PathVariable Long id, @RequestBody String title){
        Pedido p = pedidoRepository.findById(id).get();
        p.setTitulo(title);
        pedidoRepository.save(p);
    }

    @PutMapping("addPrato/{id}/{id2}")
    public void updatePedidoAdd(@PathVariable Long id, @PathVariable Long id2){
        Pedido p = pedidoRepository.findById(id).get();
        p.getPratos().add(cardapioRepository.findById(id2).get());
        pedidoRepository.save(p);
    }

    @PutMapping("removerPrato/{id}/{id2}")
    public void updatePedidoRemove(@PathVariable Long id, @PathVariable Long id2){
        Pedido p = pedidoRepository.findById(id).get();
        p.getPratos().remove(cardapioRepository.findById(id2).get());
        pedidoRepository.save(p);
    }
}
