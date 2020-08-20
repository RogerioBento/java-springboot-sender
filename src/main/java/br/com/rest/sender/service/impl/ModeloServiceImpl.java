package br.com.rest.sender.service.impl;

import br.com.rest.sender.core.client.ReceiverModeloClient;
import br.com.rest.sender.core.dto.ModeloDto;
import br.com.rest.sender.service.ModeloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ModeloServiceImpl implements ModeloService {

    private final ReceiverModeloClient modeloClient;

    @Override
    public List<ModeloDto> buscarTodos() {
        log.info("STEP -> Executing findAll");

        try {
            return modeloClient.findAll();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Http exception: ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("Unknown exception: ", e.getMessage());
            throw e;
        }
    }

    @Override
    public ModeloDto buscarPorId(Integer id) {
        log.info("STEP -> Executing findById");

        try {
            return modeloClient.findById(id);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Http exception: ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("Unknown exception: ", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ModeloDto> buscarPorNome(String nome) {
        log.info("STEP -> Executing findByName");

        try {
            return modeloClient.findByName(nome);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Http exception: ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("Unknown exception: ", e.getMessage());
            throw e;
        }
    }

    @Override
    public ModeloDto salvar(ModeloDto modelo) {
        log.info("STEP -> Executing create");

        try {
            return modeloClient.create(modelo);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Http exception: ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("Unknown exception: ", e.getMessage());
            throw e;
        }
    }

    @Override
    public void alterar(Integer id, ModeloDto modelo) {
        log.info("STEP -> Executing update");

        try {
            modeloClient.update(id, modelo);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Http exception: ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("Unknown exception: ", e.getMessage());
            throw e;
        }
    }

    @Override
    public void deletar(Integer id) {
        log.info("STEP -> Executing delete");

        try {
            modeloClient.delete(id);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Http exception: ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info("Unknown exception: ", e.getMessage());
            throw e;
        }
    }

}