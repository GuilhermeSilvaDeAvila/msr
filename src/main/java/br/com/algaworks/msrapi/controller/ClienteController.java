package br.com.algaworks.msrapi.controller;

import br.com.algaworks.msrapi.domain.repository.ClientRepository;
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
public class ClienteController {


    private ClientRepository clientRepository;
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getByIdClient(@PathVariable Long clientId){
        return clientService.getByIdClient(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client){
        clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClientById(@Valid @PathVariable Long clientId, @RequestBody Client client){
        if(clientService.getByIdClient(clientId).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        clientService.createClient(client);

        return ResponseEntity.status(HttpStatus.OK).body(client);
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
