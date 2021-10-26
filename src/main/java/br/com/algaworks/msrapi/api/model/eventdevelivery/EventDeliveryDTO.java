package br.com.algaworks.msrapi.api.model.eventdevelivery;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EventDeliveryDTO {

    private Long id;

    @NotNull
    private String description;

    private OffsetDateTime dateRegister;
}
