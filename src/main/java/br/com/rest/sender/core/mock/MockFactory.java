package br.com.rest.sender.core.mock;

import java.util.List;

import br.com.rest.sender.core.dto.CarroDto;
import br.com.rest.sender.core.dto.ModeloDto;

public class MockFactory {

    public static CarroDto mockCarroDto() {
        return CarroDto.builder()
                .id(1)
                .cor("cor")
                .modelo(mockModeloDto())
                .placa("placa")
                .valor(1.0)
                .build();
    }

    public static ModeloDto mockModeloDto() {
        return ModeloDto.builder()
                .id(1)
                .nome("nome")
                .build();
    }

    public static List<CarroDto> mockCarroDtoList() {
        return List.of(mockCarroDto());
    }

    public static List<ModeloDto> mockModeloDtoList() {
        return List.of(mockModeloDto());
    }
}