package ru.job4j.integration;

import lombok.*;

import java.sql.Timestamp;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 07/08/2022 - 20:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Order {
    private int id;

    private String name;

    private String description;

    private Timestamp created;

    public static Order of(String name, String description) {
        Order o = new Order();
        o.name = name;
        o.description = description;
        o.created = new Timestamp(System.currentTimeMillis());
        return o;
    }
}
