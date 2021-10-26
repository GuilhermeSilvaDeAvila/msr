package br.com.algaworks.msrapi.api.model.delivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddresseeDTO {

    private String name;
    private String street;
    private String number;
    private String complement;
    private String neighboord;

}
