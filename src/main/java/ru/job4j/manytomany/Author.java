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
 * @created 10/07/2022 - 18:52
 */
@Entity
@Table(name = "authors")
@Getter
@Setter
@EqualsAndHashCode
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Book> books = new HashSet<>();

    public static Author of(String name) {
        Author author = new Author();
        author.name = name;
        return author;
    }
}
