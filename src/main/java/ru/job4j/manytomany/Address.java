package ru.job4j.manytomany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 18:41
 */
@Entity
@Table(name = "addresses")
@Getter
@Setter
@EqualsAndHashCode
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;

    private String number;

    public static Address of(String street, String number) {
        Address address = new Address();
        address.street = street;
        address.number = number;
        return address;
    }
}

