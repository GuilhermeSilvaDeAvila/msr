package br.com.algaworks.msrapi.api.mapper;

import br.com.algaworks.msrapi.api.model.delivery.DeliveryDTO;
import br.com.algaworks.msrapi.api.model.delivery.DeliveryRequestDTO;
import br.com.algaworks.msrapi.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;

    public DeliveryDTO toModel(Delivery delivery){
        return modelMapper.map(delivery, DeliveryDTO.class);
    }
    public List<DeliveryDTO> toCollectionModel(List<Delivery> delivery){
        return delivery.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryRequestDTO deliveryRequestDTO){
        return modelMapper.map(deliveryRequestDTO, Delivery.class);
    }

}
