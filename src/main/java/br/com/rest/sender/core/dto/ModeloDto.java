package br.com.rest.sender.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModeloDto {

  @JsonProperty("idmodelo")
  private Integer id;

  private String nome;
  
}

