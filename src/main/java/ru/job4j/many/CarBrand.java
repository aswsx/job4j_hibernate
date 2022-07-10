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
 * @created 10/07/2022 - 18:07
 */
@Entity
@Table(name = "c_brand")
@Getter
@Setter
@EqualsAndHashCode
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarModel> models = new ArrayList<>();

    public void addModel(CarModel cb) {
        this.models.add(cb);
    }

    public static CarBrand of(String name) {
        CarBrand brand = new CarBrand();
        brand.name = name;
        return brand;
    }
}
