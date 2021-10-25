package br.com.algaworks.msrapi.domain.service;

import br.com.algaworks.msrapi.domain.exception.BusinessException;
import br.com.algaworks.msrapi.domain.model.Client;
import br.com.algaworks.msrapi.domain.model.Delivery;
import br.com.algaworks.msrapi.domain.model.StatusDelivery;
import br.com.algaworks.msrapi.domain.repository.ClientRepository;
import br.com.algaworks.msrapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;
    private ClientService clientService;

    public Delivery createDelivery(Delivery delivery){

        Client client = clientService.buscar(delivery.getClient());

        delivery.setClient(client);
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setDateOrder(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }

    @Transactional
    public List<Delivery> getAllDelivery(){
        return deliveryRepository.findAll();
    }

    @Transactional
    public Optional<Delivery> getByIdDelivery(Long deliveryId){
        return deliveryRepository.findById(deliveryId);
    }


}
