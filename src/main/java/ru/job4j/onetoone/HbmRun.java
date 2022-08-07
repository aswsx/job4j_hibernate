package ru.job4j.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Timestamp;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 07/08/2022 - 17:50
 */
public class HbmRun {
    public static void main(String[] args) {
        Candidate rsl = null;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            Session session = sf.openSession();
            session.beginTransaction();

            Candidate candidate = Candidate.of("Alex",
                    new Timestamp(1124031212015L), "50000");
            Vacancy vacancy = Vacancy.of("Dream Job", "Java Developer");
            VacancyDB base = VacancyDB.of("Engineers");
            base.addVacancy(vacancy);
            candidate.setBase(base);

            session.save(vacancy);
            session.save(base);
            session.save(candidate);

            rsl = session.createQuery(
                    "select distinct c from Candidate c "
                            + "join fetch c.base d "
                            + "join fetch d.vacancies v "
                            + "where c.id = :cId", Candidate.class
            ).setParameter("cId", candidate.getId()).uniqueResult();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        System.out.println(rsl);
    }
}
