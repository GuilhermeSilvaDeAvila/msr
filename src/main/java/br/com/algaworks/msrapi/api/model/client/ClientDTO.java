package br.com.algaworks.msrapi.api.model.client;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientDTO {

    @NotNull
    private Long id;

    private String name;
    private String email;
    private String phone;
}
