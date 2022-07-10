package ru.job4j.many;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 17:42
 */
@Entity
@Table(name = "j_user")
@Getter
@Setter
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public static User of(String name) {
        User user = new User();
        user.name = name;
        return user;
    }
}