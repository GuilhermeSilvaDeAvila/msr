package br.com.algaworks.msrapi.api.model.eventdevelivery;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EventDeliveryRequest {

    @NotBlank
    private String description;
}
