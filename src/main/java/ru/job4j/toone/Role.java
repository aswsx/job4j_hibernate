package ru.job4j.toone;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 10:49
 */
@Entity
@Table(name = "j_role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public static Role of(String name) {
        Role role = new Role();
        role.name = name;
        return role;
    }
}
