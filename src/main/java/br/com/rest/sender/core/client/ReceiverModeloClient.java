package br.com.rest.sender.core.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rest.sender.api.constant.UriConstants;
import br.com.rest.sender.core.dto.ModeloDto;

@FeignClient(url = "${api.receiver.uri}", name = "receiverModelo")
public interface ReceiverModeloClient {

    // GET
    @GetMapping(value = UriConstants.ReceiverModelo.V1_Modelo)
    public List<ModeloDto> findAll();

    @GetMapping(value = UriConstants.ReceiverModelo.V1_Modelo_Id)
    public ModeloDto findById(@PathVariable Integer id);

    @GetMapping(value = UriConstants.ReceiverModelo.V1_Modelo_Nome)
    public List<ModeloDto> findByName(@PathVariable("nome") String nome);

    // POST
    @PostMapping(value = UriConstants.ReceiverModelo.V1_Modelo)
    public ModeloDto create(@RequestBody ModeloDto modelo);

    // PUT
    @PutMapping(value = UriConstants.ReceiverModelo.V1_Modelo_Id)
    public ResponseEntity update(@PathVariable Integer id, @RequestBody ModeloDto modelo);

    // DELETE
    @DeleteMapping(value = UriConstants.ReceiverModelo.V1_Modelo_Id)
    public ResponseEntity delete(@PathVariable("id") int id);
}