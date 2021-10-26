package br.com.algaworks.msrapi.api.model.delivery;

import br.com.algaworks.msrapi.domain.model.StatusDelivery;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDTO {

    @NotNull
    private Long id;

    @NotBlank
    private DeliveryClientDTO client;

    @NotBlank
    private DeliveryAddresseeDTO addressee;

    @NotBlank
    private BigDecimal tax;

    @NotNull
    private StatusDelivery status;

    @NotNull
    private OffsetDateTime dateOrder;

    private OffsetDateTime dateFinished;
}
