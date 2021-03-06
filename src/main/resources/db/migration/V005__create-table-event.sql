create table event (
    id bigint not null auto_increment,
    delivery_id bigint not null,
    description text not null,
    date_register datetime not null,

    primary key(id)
);

alter table event add constraint fk_event_delivery
foreign key (delivery_id) references event(id);