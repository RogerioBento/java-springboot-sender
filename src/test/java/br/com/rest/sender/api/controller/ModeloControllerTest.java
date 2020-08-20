package br.com.rest.sender.api.controller;

import br.com.rest.sender.core.dto.ModeloDto;
import br.com.rest.sender.service.ModeloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static br.com.rest.sender.core.mock.MockFactory.mockModeloDto;
import static br.com.rest.sender.core.mock.MockFactory.mockModeloDtoList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ModeloControllerTest {

    @Mock
    private ModeloService modeloService;

    @InjectMocks
    private ModeloController modeloController;

    @BeforeEach
    public void init() {
        when(modeloService.buscarTodos())
                .thenReturn(mockModeloDtoList());

        when(modeloService.buscarPorNome(anyString()))
                .thenReturn(mockModeloDtoList());

        when(modeloService.buscarPorId(anyInt()))
                .thenReturn(mockModeloDto());

        when(modeloService.salvar(any(ModeloDto.class)))
                .thenReturn(mockModeloDto());

        doNothing().when(modeloService)
                .alterar(anyInt(), any(ModeloDto.class));

        doNothing().when(modeloService)
                .deletar(anyInt());
    }

    @Test
    void fildAllTest() {
        List<ModeloDto> expected = modeloController.fildAll();

        assertNotNull(expected);
        assertFalse(expected.isEmpty());
    }

    @Test
    void findByIdTest() {
        ModeloDto expected = modeloController.findById(1);

        assertNotNull(expected);
    }

    @Test
    void findByNameTest() {
        List<ModeloDto> expected = modeloController.findByName("nome");

        assertNotNull(expected);
        assertFalse(expected.isEmpty());
    }

    @Test
    void novoTest() {
        ModeloDto expected = modeloController.novo(new ModeloDto());

        assertNotNull(expected);
    }

    @Test
    void alterarTest() {
        modeloController.alterar(1, new ModeloDto());

        assertTrue(true);
    }

    @Test
    void deletarTest() {
        modeloController.deletar(1);

        assertTrue(true);
    }
}
