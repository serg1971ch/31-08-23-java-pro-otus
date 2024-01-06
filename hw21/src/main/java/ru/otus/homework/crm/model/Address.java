package ru.otus.homework.crm.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "address")
public class Address {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "street")
    String street;

    public Address(Long id, String street) {
        this.id = id;
    }

    @Override
    public Address clone()  {
        return new Address(id, street);
    }

    public Address() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public Long getId() {
        return id;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
