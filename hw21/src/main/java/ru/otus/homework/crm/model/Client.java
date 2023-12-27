package ru.otus.homework.crm.model;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.util.*;


@Entity
@Table(name = "client")
public class Client implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Getter
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Phone> phones;

    public Client(){

    }
    public Client(String name){
        this.name = name;
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(Long id, String name, Address address, List<Phone> phones) {
        this.id = id;
        this.name = name;
        if (address != null) {
            this.address = new Address(address.getId(), address.getStreet());
        } else {
            this.address = null;
        }
        this.phones = setPhones(phones);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Phone> setPhones(List<Phone> phones) {
        this.phones = phones;
        phones.forEach(p->p.setClient(this));
        return phones;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Client clone() throws CloneNotSupportedException {
        return new Client(this.id, this.name, this.address, this.phones);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
