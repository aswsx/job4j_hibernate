package ru.job4j.toone;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 10:51
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

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public static User of(String name, Role role) {
        User user = new User();
        user.name = name;
        user.role = role;
        return user;
    }
}