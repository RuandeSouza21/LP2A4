package br.ruan.Restaurante.controller;

import br.ruan.Restaurante.dto.CardapioRequestDTO;
import br.ruan.Restaurante.dto.CardapioResponseDTO;
import br.ruan.Restaurante.model.Prato;
import br.ruan.Restaurante.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cardapio")
public class CardapioController {
    @Autowired
    CardapioRepository cardapioRepository;

    @GetMapping
    public List<CardapioResponseDTO> getAll(){

        /*
        List<CardapioResponseDTO> a = new ArrayList<>();

        for(Prato p : pratos){
            a.add(new CardapioResponseDTO(p));
        }
        return a;

         */

        //return pratos.stream().map(CardapioResponseDTO::new).toList();

        return cardapioRepository.findAll().stream().map(CardapioResponseDTO::new).toList();
    }

    @PostMapping
    public void addPrato(@RequestBody CardapioRequestDTO data){
        cardapioRepository.save(new Prato(data));
    }

    @DeleteMapping("{id}")
    public void deletePrato(@PathVariable Long id){
        for (Prato p : cardapioRepository.findAll()){
            if (p.getId().equals(id)){
                cardapioRepository.delete(p);
            }
        }
    }

    /*
    @DeleteMapping("/{id}")
    public void deletarPrato(@PathVariable Long id){
        cardapioRepository.deleteById(id);
    }
     */

    @PutMapping("{id}")
    public void updatePrato(@PathVariable Long id, @RequestBody CardapioRequestDTO data){
        Prato p = new Prato(data);
        p.setId(id);
        cardapioRepository.save(p);
    }
}
