package br.com.algaworks.msrapi.api.controller;

import br.com.algaworks.msrapi.api.mapper.ClientMapper;
import br.com.algaworks.msrapi.api.model.client.ClientDTO;
import br.com.algaworks.msrapi.api.model.client.ClientRequestDTO;
import br.com.algaworks.msrapi.domain.service.ClientService;
import br.com.algaworks.msrapi.domain.model.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;
    private ClientMapper clientMapper;

    @GetMapping
    public List<ClientDTO> getAllClient(){
        return clientMapper.toCollectionModel(clientService.getAllClient());
    }


    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getByIdClient(@PathVariable Long clientId){
        return clientService.getByIdClient(clientId)
                .map(client -> ResponseEntity.ok(clientMapper.toModel(client)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO){
        Client client = clientMapper.toEntity(clientRequestDTO);
        clientService.createClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.toModel(client));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> updateClientById(@Valid @PathVariable Long clientId, @RequestBody ClientRequestDTO clientRequestDTO){
        Client client = clientMapper.toEntity(clientRequestDTO);

        if(clientService.getByIdClient(clientId).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        clientService.createClient(client);

        return ResponseEntity.status(HttpStatus.OK).body(clientMapper.toModel(client));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long clientId){
        if(clientService.getByIdClient(clientId).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        clientService.deleteClient(clientId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
