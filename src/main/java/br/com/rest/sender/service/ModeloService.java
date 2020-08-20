package br.com.rest.sender.service;

import java.util.List;

import br.com.rest.sender.core.dto.ModeloDto;

public interface ModeloService {

    public List<ModeloDto> buscarTodos();

    public ModeloDto buscarPorId(Integer id);

    public List<ModeloDto> buscarPorNome(String nome);

    
    public ModeloDto salvar(ModeloDto modelo);


    public void alterar(Integer id, ModeloDto modelo);


    public void deletar(Integer id);

}