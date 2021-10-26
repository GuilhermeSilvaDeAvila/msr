package br.com.algaworks.msrapi.domain.service;

import br.com.algaworks.msrapi.domain.model.Delivery;
import br.com.algaworks.msrapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinishedDeliveryService {

    private FindDeliveryService findDeliveryService;

    @Transactional
    public void finished(Long deliveryId){
        Delivery delivery = findDeliveryService.find(deliveryId);

        delivery.finished();
    }
}
