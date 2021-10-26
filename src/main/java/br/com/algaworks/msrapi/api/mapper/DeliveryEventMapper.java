package br.com.algaworks.msrapi.api.mapper;

import br.com.algaworks.msrapi.api.model.eventdevelivery.EventDeliveryDTO;
import br.com.algaworks.msrapi.domain.model.EventDelivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryEventMapper {

    private ModelMapper modelMapper;

    public EventDeliveryDTO toModel(EventDelivery eventDelivery){
        return modelMapper.map(eventDelivery, EventDeliveryDTO.class);
    }

    public List<EventDeliveryDTO> toCollectionModel(List<EventDelivery> events) {
        return events.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
