package ru.job4j.lazyinitializationexception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 11/07/2022 - 21:33
 */
@Entity
@Table(name = "brands")
@Getter
@Setter
@EqualsAndHashCode
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "brand")
    private List<CarModel> models = new ArrayList<>();

    public static CarBrand of(String name) {
        CarBrand brand = new CarBrand();
        brand.name = name;
        return brand;
    }

    @Override
    public String toString() {
        return String.format("CarBrand(id=%s ,name=%s)",
                this.id,
                this.name);
    }
}
