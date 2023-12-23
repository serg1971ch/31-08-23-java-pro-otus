package ru.otus.crm.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
//import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "number")
    String number;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;


    public Phone(Long id, String number) {
        this.id = id;
        this.number = number;
    }

//    @Override
//    public Phone clone() throws CloneNotSupportedException {
//        Phone clone = (Phone) super.clone();
//        return new Phone(id,number);
//    }

    public Phone() {
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
