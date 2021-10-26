package br.com.algaworks.msrapi.domain.service;


import br.com.algaworks.msrapi.domain.exception.BusinessException;
import br.com.algaworks.msrapi.domain.exception.EntityNotFoundException;
import br.com.algaworks.msrapi.domain.model.Delivery;
import br.com.algaworks.msrapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery find(Long deliveryId){
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
    }
}
