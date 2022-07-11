package ru.job4j.lazyinitializationexception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 11/07/2022 - 21:33
 */
@Entity
@Table(name = "models")
@Getter
@Setter
@EqualsAndHashCode
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand brand;

    public static CarModel of(String name) {
        CarModel carModel = new CarModel();
        carModel.name = name;
        return carModel;
    }

    @Override
    public String toString() {
        return String.format("CarModel(id=%s ,name=%s ,brand=%s)",
                this.id,
                this.name,
                this.brand);
    }
}
