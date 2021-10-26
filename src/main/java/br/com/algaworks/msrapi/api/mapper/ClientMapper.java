package br.com.algaworks.msrapi.api.mapper;

import br.com.algaworks.msrapi.api.model.client.ClientDTO;
import br.com.algaworks.msrapi.api.model.client.ClientRequestDTO;
import br.com.algaworks.msrapi.domain.model.Client;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ClientMapper {

    private ModelMapper modelMapper;

    public ClientDTO toModel(Client client){
        return modelMapper.map(client, ClientDTO.class);
    }

    public List<ClientDTO> toCollectionModel(List<Client> client){
        return client.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Client toEntity(ClientRequestDTO clientRequestDTO){
        return modelMapper.map(clientRequestDTO, Client.class);
    }
}
