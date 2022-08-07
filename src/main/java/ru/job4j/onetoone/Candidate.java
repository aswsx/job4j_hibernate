package ru.job4j.onetoone;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 07/08/2022 - 17:14
 */
@Entity
@Table(name = "candidates")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Timestamp experience;

    private String salary;

    public static Candidate of(String name, Timestamp experience, String salary) {
        Candidate candidate = new Candidate();
        candidate.name = name;
        candidate.experience = experience;
        candidate.salary = salary;
        return candidate;
    }

    @OneToOne
    private VacancyDB base;
}
