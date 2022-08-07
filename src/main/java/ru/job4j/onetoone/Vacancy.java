package ru.job4j.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 07/08/2022 - 16:18
 */
@Entity
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    public static Vacancy of(String name, String description) {
        Vacancy vacancy = new Vacancy();
        vacancy.name = name;
        vacancy.description = description;
        return vacancy;
    }
    
}
