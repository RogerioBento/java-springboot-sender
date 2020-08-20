package br.com.rest.sender.service.impl;

import br.com.rest.sender.core.client.ReceiverModeloClient;
import br.com.rest.sender.core.dto.ModeloDto;
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

import static br.com.rest.sender.core.mock.MockFactory.mockModeloDto;
import static br.com.rest.sender.core.mock.MockFactory.mockModeloDtoList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ModeloServiceImplTest {

    @Mock
    private ReceiverModeloClient modeloClient;

    @InjectMocks
    private ModeloServiceImpl modeloService;

    @BeforeEach
    public void init() {
        ResponseEntity responseMock = ResponseEntity.status(HttpStatus.OK).build();

        when(modeloClient.findAll())
                .thenReturn(mockModeloDtoList());

        when(modeloClient.findById(anyInt()))
                .thenReturn(mockModeloDto());

        when(modeloClient.findByName(anyString()))
                .thenReturn(mockModeloDtoList());

        when(modeloClient.create(any(ModeloDto.class)))
                .thenReturn(mockModeloDto());

        when(modeloClient.update(anyInt(), any(ModeloDto.class)))
                .thenReturn(responseMock);

        when(modeloClient.delete(anyInt()))
                .thenReturn(responseMock);
    }

    // buscarTodos
    @Test
    void buscarTodosTest() {
        List<ModeloDto> expected = modeloService.buscarTodos();

        assertNotNull(expected);
    }

    @Test
    void buscarTodosTest_WithException_HttpClientException() {
        when(modeloClient.findAll())
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            modeloService.buscarTodos();
        });
    }

    @Test
    void buscarTodosTest_WithException_NullPointerException() {
        when(modeloClient.findAll())
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            modeloService.buscarTodos();
        });
    }

    // buscarPorId
    @Test
    void buscarPorIdTest() {
        ModeloDto expected = modeloService.buscarPorId(1);

        assertNotNull(expected);
    }

    @Test
    void buscarPorIdTest_WithException_HttpClientException() {
        when(modeloClient.findById(anyInt()))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            modeloService.buscarPorId(1);
        });
    }

    @Test
    void buscarPorIdTest_WithException_NullPointerException() {
        when(modeloClient.findById(anyInt()))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            modeloService.buscarPorId(1);
        });
    }

    // buscarPorNome
    @Test
    void buscarPorNomeTest() {
        List<ModeloDto> expected = modeloService.buscarPorNome("nome");

        assertNotNull(expected);
    }

    @Test
    void buscarPorNomeTest_WithException_HttpClientException() {
        when(modeloClient.findByName(anyString()))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            modeloService.buscarPorNome("nome");
        });
    }

    @Test
    void buscarPorNomeTest_WithException_NullPointerException() {
        when(modeloClient.findByName(anyString()))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            modeloService.buscarPorNome("nome");
        });
    }

    // Salvar
    @Test
    void salvarTest() {
        ModeloDto expected = modeloService.salvar(mockModeloDto());

        assertNotNull(expected);
    }

    @Test
    void salvarTest_WithException_HttpClientException() {
        when(modeloClient.create(any(ModeloDto.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            modeloService.salvar(mockModeloDto());
        });
    }

    @Test
    void salvarTest_WithException_NullPointerException() {
        when(modeloClient.create(any(ModeloDto.class)))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            modeloService.salvar(mockModeloDto());
        });
    }

    // alterar
    @Test
    void alterarTest() {
        modeloService.alterar(1, mockModeloDto());

        assertTrue(true);
    }

    @Test
    void alterarTest_WithException_HttpClientException() {
        when(modeloClient.update(anyInt(), any(ModeloDto.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            modeloService.alterar(1, mockModeloDto());
        });
    }

    @Test
    void alterarTest_WithException_NullPointerException() {
        when(modeloClient.update(anyInt(), any(ModeloDto.class)))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            modeloService.alterar(1, mockModeloDto());
        });
    }

    // deletar
    @Test
    void deletarTest() {
        modeloService.deletar(1);

        assertTrue(true);
    }

    @Test
    void deletarTest_WithException_HttpClientException() {
        when(modeloClient.update(anyInt(), any(ModeloDto.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(HttpClientErrorException.class, () -> {
            modeloService.alterar(1, mockModeloDto());
        });
    }

    @Test
    void deletarTest_WithException_NullPointerException() {
        when(modeloClient.update(anyInt(), any(ModeloDto.class)))
                .thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            modeloService.alterar(1, mockModeloDto());
        });
    }
}
