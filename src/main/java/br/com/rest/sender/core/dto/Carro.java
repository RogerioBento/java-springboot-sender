package br.com.rest.sender.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carro {
  private String cor;

  private Modelo modelo;

  private String placa;

  private Integer valor;

}

