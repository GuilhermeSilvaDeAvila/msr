package br.com.algaworks.msrapi.api.model;

import br.com.algaworks.msrapi.domain.model.Addressee;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class DeliveryDTO {

    private Long id;
    private String nameCliente;
    private AddresseeModel addressee;
    private BigDecimal tax;
    private OffsetDateTime date_order;
    private OffsetDateTime date_finished;
}
