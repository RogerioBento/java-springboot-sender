package br.com.rest.sender.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.sender.api.constant.UriConstants;
import br.com.rest.sender.core.dto.CarroDto;
import br.com.rest.sender.service.CarroService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class CarroController {

    private final CarroService carroService;

    // GET
    @GetMapping(value = UriConstants.SenderCarro.V1_Carro)
    @ResponseBody
    public List<CarroDto> fildAll() {
        return carroService.buscarTodos();
    }

    @GetMapping(value = UriConstants.SenderCarro.V1_Carro_Id)
    @ResponseBody
    public CarroDto findById(@PathVariable("id") Integer id) {
        return carroService.buscarPorId(id);
    }

    @GetMapping(value = UriConstants.SenderCarro.V1_Carro_Nome)
    @ResponseBody
    public List<CarroDto> findByName(@PathVariable("nome") String nome) {
        return carroService.buscarPorNome(nome);
    }

    // POST
    @PostMapping(value = UriConstants.SenderCarro.V1_Carro)
    @ResponseStatus(HttpStatus.CREATED)
    public CarroDto novo(@RequestBody CarroDto carro) {
        return carroService.salvar(carro);
    }

    // PUT
    @PutMapping(value = UriConstants.SenderCarro.V1_Carro)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterar(@PathVariable Integer id, @RequestBody CarroDto carro) {
        carroService.alterar(id, carro);
    }

    // DELETE
    @DeleteMapping(value = UriConstants.SenderCarro.V1_Carro_Id)
    public void deletar(@PathVariable("id") Integer id) {
        carroService.deletar(id);
    }

}