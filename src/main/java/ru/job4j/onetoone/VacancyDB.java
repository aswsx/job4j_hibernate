package ru.job4j.onetoone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 07/08/2022 - 16:18
 */
@Entity
@Table(name = "vacancies")
public class VacancyDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Vacancy> vacancies = new ArrayList<>();

    public static VacancyDB of(String name) {
        VacancyDB db = new VacancyDB();
        db.name = name;
        return db;
    }

    public void addVacancy(Vacancy vacancy) {
        this.vacancies.add(vacancy);
    }
}
