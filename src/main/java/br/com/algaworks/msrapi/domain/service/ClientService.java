package br.com.algaworks.msrapi.domain.service;

import br.com.algaworks.msrapi.domain.exception.BusinessException;
import br.com.algaworks.msrapi.domain.repository.ClientRepository;
import br.com.algaworks.msrapi.domain.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Transactional
    public Client createClient(Client client){
        boolean emailPresent = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientExist -> !clientExist.equals(client));
        System.out.println(emailPresent);
        if(emailPresent){
            throw new BusinessException("Já existe um cliente cadastrado com este e-mail");
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long clientId){
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    @Transactional
    public Optional<Client> getByIdClient(Long clientId){
        return clientRepository.findById(clientId);
    }

    public Client buscar(Client client){
        return clientRepository.findById(client.getId())
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
    }
}
