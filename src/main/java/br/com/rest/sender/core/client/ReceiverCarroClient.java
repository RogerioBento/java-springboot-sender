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
import br.com.rest.sender.core.dto.CarroDto;

@FeignClient(url = "${api.receiver.uri}", name = "receiverCarro")
public interface ReceiverCarroClient {

    // GET
    @GetMapping(value = UriConstants.ReceiverCarro.V1_Carro)
    public List<CarroDto> findAll();

    @GetMapping(value = UriConstants.ReceiverCarro.V1_Carro_Id)
    public CarroDto findById(@PathVariable Integer id);

    @GetMapping(value = UriConstants.ReceiverCarro.V1_Carro_Nome)
    public List<CarroDto> findByName(@PathVariable("nome") String nome);

    // POST
    @PostMapping(value = UriConstants.ReceiverCarro.V1_Carro)
    public CarroDto create(@RequestBody CarroDto carro);

    // PUT
    @PutMapping(value = UriConstants.ReceiverCarro.V1_Carro_Id)
    public ResponseEntity update(@PathVariable Integer id, @RequestBody CarroDto carro);

    // DELETE
    @DeleteMapping(value = UriConstants.ReceiverCarro.V1_Carro_Id)
    public ResponseEntity delete(@PathVariable("id") int id);

}