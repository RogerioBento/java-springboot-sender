package br.com.rest.sender.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import br.com.rest.sender.core.client.ReceiverCarroClient;
import br.com.rest.sender.core.dto.CarroDto;
import br.com.rest.sender.service.CarroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CarroServiceImpl implements CarroService {

    private final String constMessageException = "Http exception: ";
    private final String constMessageUnknownException = "Unknown exception: ";
    private final ReceiverCarroClient carroClient;

    @Override
    public List<CarroDto> buscarTodos() {
        log.info("STEP -> Executing findAll");

        try {
            return carroClient.findAll();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info(constMessageException, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info(constMessageUnknownException, e.getMessage());
            throw e;
        }
    }

    @Override
    public CarroDto buscarPorId(Integer id) {
        log.info("STEP -> Executing findById");

        try {
            return carroClient.findById(id);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info(constMessageException, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info(constMessageUnknownException, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CarroDto> buscarPorNome(String nome) {
        log.info("STEP -> Executing findByName");

        try {
            return carroClient.findByName(nome);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info(constMessageException, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info(constMessageUnknownException, e.getMessage());
            throw e;
        }
    }

    @Override
    public CarroDto salvar(CarroDto carro) {
        log.info("STEP -> Executing create");

        try {
            return carroClient.create(carro);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info(constMessageException, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info(constMessageUnknownException, e.getMessage());
            throw e;
        }
    }

    @Override
    public void alterar(Integer id, CarroDto carro) {
        log.info("STEP -> Executing update");

        try {
            carroClient.update(id, carro);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info(constMessageException, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info(constMessageUnknownException, e.getMessage());
            throw e;
        }
    }

    @Override
    public void deletar(Integer id) {
        log.info("STEP -> Executing delete");

        try {
            carroClient.delete(id);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info(constMessageException, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.info(constMessageUnknownException, e.getMessage());
            throw e;
        }
    }

}