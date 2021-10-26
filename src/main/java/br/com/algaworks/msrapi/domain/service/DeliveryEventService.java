package br.com.algaworks.msrapi.domain.service;

import br.com.algaworks.msrapi.domain.model.Delivery;
import br.com.algaworks.msrapi.domain.model.EventDelivery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeliveryEventService {

    private FindDeliveryService findDeliveryService;

    @Transactional
    public EventDelivery register(Long deliveryId, String description){
        Delivery delivery = findDeliveryService.find(deliveryId);

        return delivery.addEvent(description);
    }

}
