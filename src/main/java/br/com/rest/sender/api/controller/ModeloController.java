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
import br.com.rest.sender.core.dto.ModeloDto;
import br.com.rest.sender.service.ModeloService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class ModeloController {
    
    private final ModeloService modeloService;

    // GET
    @GetMapping(value = UriConstants.SenderModelo.V1_Modelo)
    @ResponseBody
    public List<ModeloDto> fildAll() {
        return modeloService.buscarTodos();
    }

    @GetMapping(value = UriConstants.SenderModelo.V1_Modelo_Id)
    @ResponseBody
    public ModeloDto findById(@PathVariable("id") Integer id) {
        return modeloService.buscarPorId(id);
    }

    @GetMapping(value = UriConstants.SenderModelo.V1_Modelo_Nome)
    @ResponseBody
    public List<ModeloDto> findByName(@PathVariable("nome") String nome) {
        return modeloService.buscarPorNome(nome);
    }

    // POST
    @PostMapping(value = UriConstants.SenderModelo.V1_Modelo)
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloDto novo(@RequestBody ModeloDto modelo) {
        return modeloService.salvar(modelo);
    }

    // PUT
    @PutMapping(value = UriConstants.SenderModelo.V1_Modelo)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterar(@PathVariable Integer id, @RequestBody ModeloDto modelo) {
        modeloService.alterar(id, modelo);
    }

    // DELETE
    @DeleteMapping(value = UriConstants.SenderModelo.V1_Modelo_Id)
    public void deletar(@PathVariable("id") Integer id) {
        modeloService.deletar(id);
    }
}