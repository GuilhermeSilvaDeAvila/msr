package br.com.algaworks.msrapi.api.controller;

import br.com.algaworks.msrapi.api.mapper.DeliveryMapper;
import br.com.algaworks.msrapi.api.model.delivery.DeliveryDTO;
import br.com.algaworks.msrapi.api.model.delivery.DeliveryRequestDTO;
import br.com.algaworks.msrapi.domain.model.Delivery;
import br.com.algaworks.msrapi.domain.service.DeliveryService;
import br.com.algaworks.msrapi.domain.service.FinishedDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private DeliveryService deliveryService;
    private FinishedDeliveryService finishedDeliveryService;
    private DeliveryMapper deliveryMapper;

    @PostMapping
    public ResponseEntity<DeliveryDTO> createDelivery(@Valid @RequestBody DeliveryRequestDTO deliveryRequestDTO){
        Delivery delivery = deliveryMapper.toEntity(deliveryRequestDTO);

        deliveryService.createDelivery(delivery);

        return ResponseEntity.status(HttpStatus.CREATED).body(deliveryMapper.toModel(delivery));
    }

    @GetMapping
    public List<DeliveryDTO> getAllDelivery(){
        return deliveryMapper.toCollectionModel(deliveryService.getAllDelivery());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryDTO> getByIdDelivery(@PathVariable Long deliveryId){
        return deliveryService.getByIdDelivery(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{deliveryId}/finished")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finished(@PathVariable Long deliveryId){
        finishedDeliveryService.finished(deliveryId);
    }
}
