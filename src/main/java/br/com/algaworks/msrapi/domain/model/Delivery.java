package br.com.algaworks.msrapi.domain.model;

import br.com.algaworks.msrapi.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(to = ValidationGroups.ClientId.class)
    @ManyToOne
    private Client client;

    @Valid
    @Embedded
    private Addressee addressee;

    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusDelivery status;

    @Column(name = "date_order")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dateOrder;

    @Column(name = "date_finished")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dateFinsihed;
}
