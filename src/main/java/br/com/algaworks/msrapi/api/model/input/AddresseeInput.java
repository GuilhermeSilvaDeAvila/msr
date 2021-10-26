package br.com.algaworks.msrapi.api.model.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddresseeInput {

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String neighboord;

}
