package ru.job4j.many;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 18:07
 */
@Entity
@Table(name = "c_model")
@Getter
@Setter
@EqualsAndHashCode
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public static CarModel of(String name) {
        CarModel model = new CarModel();
        model.name = name;
        return model;
    }

}
