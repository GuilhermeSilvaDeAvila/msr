package br.com.algaworks.msrapi.controller;

import br.com.algaworks.msrapi.domain.model.Delivery;
import br.com.algaworks.msrapi.domain.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@Valid @RequestBody Delivery delivery){
        deliveryService.createDelivery(delivery);
        return ResponseEntity.status(HttpStatus.CREATED).body(delivery);
    }

    @GetMapping
    public List<Delivery> getAllDelivery(){
        return deliveryService.getAllDelivery();
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<Delivery> getByIdDelivery(@PathVariable Long deliveryId){
        return deliveryService.getByIdDelivery(deliveryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
