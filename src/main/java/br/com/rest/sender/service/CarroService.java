package br.com.rest.sender.service;

import br.com.rest.sender.core.dto.Carro;

public interface CarroService {

    public void salvar(Carro carro);

    public void deletar(int id);

    public void buscar(String nome);

	public void buscarTodos();

}