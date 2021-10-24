package br.com.algaworks.msrapi.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Addressee {

    @NotBlank
    @Column(name = "addressee_name")
    private String name;

    @NotBlank
    @Column(name = "addressee_street")
    private String street;

    @NotBlank
    @Column(name = "addressee_number")
    private String number;

    @NotBlank
    @Column(name = "addressee_complement")
    private String complement;

    @NotBlank
    @Column(name = "addressee_neighboord")
    private String neighboord;
}
