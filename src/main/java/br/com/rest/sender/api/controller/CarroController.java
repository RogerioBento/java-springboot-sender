package br.com.rest.sender.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.rest.sender.core.dto.Carro;
import br.com.rest.sender.service.CarroService;

@RestController
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping(value = "/carros")
    public void novo(@RequestBody Carro carro) {
        carroService.salvar(carro);
    }

    @DeleteMapping(value = "/carros/{id}")
    public void deletar(@PathVariable("id") int id) {
        carroService.deletar(id);
    }

    @GetMapping(value = "/carros/nome/{nome}")
    public void buscar(@PathVariable("nome") String nome) {
        carroService.buscar(nome);
    }

    @GetMapping(value = "/carros")
    public void buscarTodos(){
        carroService.buscarTodos();
    }
}