package ru.job4j.manytomany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 18:40
 */
@Entity
@Table(name = "persons")
@Getter
@Setter
@EqualsAndHashCode
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Address> addresses = new HashSet<>();

    public static Person of(String name) {
        Person person = new Person();
        person.name = name;
        return person;
    }
}

