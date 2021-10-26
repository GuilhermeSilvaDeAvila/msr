package br.com.algaworks.msrapi.api.controller;


import br.com.algaworks.msrapi.api.mapper.DeliveryEventMapper;
import br.com.algaworks.msrapi.api.model.eventdevelivery.EventDeliveryDTO;
import br.com.algaworks.msrapi.api.model.eventdevelivery.EventDeliveryRequest;
import br.com.algaworks.msrapi.domain.model.Delivery;
import br.com.algaworks.msrapi.domain.model.EventDelivery;
import br.com.algaworks.msrapi.domain.service.DeliveryEventService;
import br.com.algaworks.msrapi.domain.service.FindDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery/{deliveryId}/events")
public class EventDeliveryController {

    private DeliveryEventService deliveryEventService;
    private DeliveryEventMapper deliveryEventMapper;
    private FindDeliveryService findDeliveryService;

    @PostMapping
    public ResponseEntity<EventDeliveryDTO> register(@PathVariable Long deliveryId,
                                                     @Valid @RequestBody EventDeliveryRequest eventDeliveryRequest){
        EventDelivery eventDelivery = deliveryEventService.register(deliveryId, eventDeliveryRequest.getDescription());

        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryEventMapper.toModel(eventDelivery));
    }

    @GetMapping
    public List<EventDeliveryDTO> getAllEvents(@PathVariable Long deliveryId) {
        Delivery delivery = findDeliveryService.find(deliveryId);

        return deliveryEventMapper.toCollectionModel(delivery.getEvents());
    }

}
