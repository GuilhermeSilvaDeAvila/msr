package br.com.algaworks.msrapi.domain.model;

import br.com.algaworks.msrapi.domain.exception.BusinessException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    private Addressee addressee;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<EventDelivery> events = new ArrayList<>();

    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    private StatusDelivery status;

    private OffsetDateTime dateOrder;

    private OffsetDateTime dateFinished;

    public EventDelivery addEvent(String description) {
        EventDelivery eventDelivery = new EventDelivery();

        eventDelivery.setDescription(description);
        eventDelivery.setDateRegister(OffsetDateTime.now());
        eventDelivery.setDelivery(this);

        this.getEvents().add(eventDelivery);

        return eventDelivery;
    }

    public void finished() {
        if(!canFinsihed()){
            throw new BusinessException("Pedido não pode ser finalizado, pois está pendente");
        }

        setStatus(StatusDelivery.FINISHED);
        setDateFinished(OffsetDateTime.now());
    }

    public boolean canFinsihed(){
        return StatusDelivery.PENDING.equals(getStatus());
    }
}
