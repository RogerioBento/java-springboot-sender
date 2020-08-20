package br.com.rest.sender.api.controller;

import static br.com.rest.sender.core.mock.MockFactory.mockCarroDto;
import static br.com.rest.sender.core.mock.MockFactory.mockCarroDtoList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.rest.sender.core.dto.CarroDto;
import br.com.rest.sender.service.CarroService;

@ExtendWith(SpringExtension.class)
class CarroControllerTest {

    @Mock
    private CarroService carroService;

    @InjectMocks
    private CarroController carroController;

    @BeforeEach
    public void init() {
        when(carroService.buscarTodos())
                .thenReturn(mockCarroDtoList());

        when(carroService.buscarPorNome(anyString()))
                .thenReturn(mockCarroDtoList());

        when(carroService.buscarPorId(anyInt()))
                .thenReturn(mockCarroDto());

        when(carroService.salvar(any(CarroDto.class)))
                .thenReturn(mockCarroDto());

        doNothing().when(carroService)
                .alterar(anyInt(), any(CarroDto.class));

        doNothing().when(carroService)
                .deletar(anyInt());
    }

    @Test
    void fildAllTest() {
        List<CarroDto> expected = carroController.fildAll();

        assertNotNull(expected);
        assertFalse(expected.isEmpty());
    }

    @Test
    void findByIdTest() {
        CarroDto expected = carroController.findById(1);

        assertNotNull(expected);
    }

    @Test
    void findByNameTest() {
        List<CarroDto> expected = carroController.findByName("nome");

        assertNotNull(expected);
        assertFalse(expected.isEmpty());
    }

    @Test
    void novoTest() {
        CarroDto expected = carroController.novo(new CarroDto());

        assertNotNull(expected);
    }

    @Test
    void alterarTest() {
        carroController.alterar(1, new CarroDto());

        assertTrue(true);
    }

    @Test
    void deletarTest() {
        carroController.deletar(1);

        assertTrue(true);
    }
}