package br.com.algaworks.msrapi.api.model.delivery;

import br.com.algaworks.msrapi.api.model.input.AddresseeInput;
import br.com.algaworks.msrapi.api.model.input.ClientInput;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryRequestDTO {

    @NotNull
    private ClientInput client;

    @Valid
    @NotNull
    private AddresseeInput addressee;

    @NotNull
    private BigDecimal tax;
}
