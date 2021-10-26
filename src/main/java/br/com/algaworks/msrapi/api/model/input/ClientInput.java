package br.com.algaworks.msrapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientInput {

    @NotNull
    private Long id;
}
