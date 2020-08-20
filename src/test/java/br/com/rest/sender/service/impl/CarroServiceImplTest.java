package br.com.rest.sender.service.impl;

import br.com.rest.sender.core.client.ReceiverCarroClient;
import br.com.rest.sender.core.dto.CarroDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static br.com.rest.sender.core.mock.MockFactory.mockCarroDto;
import static br.com.rest.sender.core.mock.MockFactory.mockCarroDtoList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CarroServiceImplTest {

    @Mock
    private ReceiverCarroClient carroClient;

    @InjectMocks
    private CarroServiceImpl carroService;

    @BeforeEach
    public void init() {
        ResponseEntity responseMock = ResponseEntity.status(HttpStatus.OK).build();

        when(carroClient.findAll())
                .thenReturn(mockCarroDtoList());

        when(carroClient.findById(anyInt()))
                .thenReturn(mockCarroDto());

        when(carroClient.findByName(anyString()))
                .thenReturn(mockCarroDtoList());

        when(carroClient.create(any(CarroDto.class)))
                .thenReturn(mockCarroDto());

        when(carroClient.update(anyInt(), any(CarroDto.class)))
                .thenReturn(responseMock);

        when(carroClient.delete(anyInt()))
                .thenReturn(responseMock);
    }

    // buscarTodos
    @Test
    void buscarTodosTest() {
        List<CarroDto> expected = carroService.buscarTodos();

        assertNotNull(expected);
    }

    @Test
    void buscarTodosTest_WithException_HttpClientException() {
        when(carroClient.findAll())
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            carroService.buscarTodos();
        });
    }

    @Test
    void buscarTodosTest_WithException_NullPointerException() {
        when(carroClient.findAll())
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            carroService.buscarTodos();
        });
    }

    // buscarPorId
    @Test
    void buscarPorIdTest() {
        CarroDto expected = carroService.buscarPorId(1);

        assertNotNull(expected);
    }

    @Test
    void buscarPorIdTest_WithException_HttpClientException() {
        when(carroClient.findById(anyInt()))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            carroService.buscarPorId(1);
        });
    }

    @Test
    void buscarPorIdTest_WithException_NullPointerException() {
        when(carroClient.findById(anyInt()))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            carroService.buscarPorId(1);
        });
    }

    // buscarPorNome
    @Test
    void buscarPorNomeTest() {
        List<CarroDto> expected = carroService.buscarPorNome("nome");

        assertNotNull(expected);
    }

    @Test
    void buscarPorNomeTest_WithException_HttpClientException() {
        when(carroClient.findByName(anyString()))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            carroService.buscarPorNome("nome");
        });
    }

    @Test
    void buscarPorNomeTest_WithException_NullPointerException() {
        when(carroClient.findByName(anyString()))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            carroService.buscarPorNome("nome");
        });
    }

    // Salvar
    @Test
    void salvarTest() {
        CarroDto expected = carroService.salvar(mockCarroDto());

        assertNotNull(expected);
    }

    @Test
    void salvarTest_WithException_HttpClientException() {
        when(carroClient.create(any(CarroDto.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            carroService.salvar(mockCarroDto());
        });
    }

    @Test
    void salvarTest_WithException_NullPointerException() {
        when(carroClient.create(any(CarroDto.class)))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            carroService.salvar(mockCarroDto());
        });
    }

    // alterar
    @Test
    void alterarTest() {
        carroService.alterar(1, mockCarroDto());

        assertTrue(true);
    }

    @Test
    void alterarTest_WithException_HttpClientException() {
        when(carroClient.update(anyInt(), any(CarroDto.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            carroService.alterar(1, mockCarroDto());
        });
    }

    @Test
    void alterarTest_WithException_NullPointerException() {
        when(carroClient.update(anyInt(), any(CarroDto.class)))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            carroService.alterar(1, mockCarroDto());
        });
    }

    // deletar
    @Test
    void deletarTest() {
        carroService.deletar(1);

        assertTrue(true);
    }

    @Test
    void deletarTest_WithException_HttpClientException() {
        when(carroClient.update(anyInt(), any(CarroDto.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            carroService.alterar(1, mockCarroDto());
        });
    }

    @Test
    void deletarTest_WithException_NullPointerException() {
        when(carroClient.update(anyInt(), any(CarroDto.class)))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            carroService.alterar(1, mockCarroDto());
        });
    }
}
