package ru.job4j.many;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 17:39
 */
@Entity
@Table(name = "j_role")
@Getter
@Setter
@EqualsAndHashCode
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public void addUser(User u) {
        this.users.add(u);
    }

    public static Role of(String name) {
        Role role = new Role();
        role.name = name;
        return role;
    }
}
