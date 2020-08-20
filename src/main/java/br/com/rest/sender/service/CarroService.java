package br.com.rest.sender.service;

import java.util.List;

import br.com.rest.sender.core.dto.CarroDto;

public interface CarroService {

    public List<CarroDto> buscarTodos();

    public CarroDto buscarPorId(Integer id);

    public List<CarroDto> buscarPorNome(String nome);

    
    public CarroDto salvar(CarroDto carro);


    public void alterar(Integer id, CarroDto carro);


    public void deletar(Integer id);

}