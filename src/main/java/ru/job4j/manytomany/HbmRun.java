package ru.job4j.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 18:44
 */
public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
/*
            Address one = Address.of("Kazanskaya", "1");
            Address two = Address.of("Piterskaya", "10");

            Person first = Person.of("Nikolay");
            first.getAddresses().add(one);
            first.getAddresses().add(two);

            Person second = Person.of("Anatoliy");
            second.getAddresses().add(two);

            session.save(first);
            session.save(second);

            session.persist(first);
            session.persist(second);


            Person person = session.get(Person.class, 1);
            session.remove(person);
 */
            Book one = Book.of("Head first Java");
            Book two = Book.of("To Kill a Mockingbird");
            Book three = Book.of("Pride and Prejudice");

            Author first = Author.of("Harper Lee");
            first.getBooks().add(one);
            first.getBooks().add(two);

            Author second = Author.of("Kathy Sierra");
            second.getBooks().add(one);
            second.getBooks().add(two);
            second.getBooks().add(three);
/*
            session.save(first);
            session.save(second);

 */
            session.persist(first);
            session.persist(second);

            Author author = session.get(Author.class, 1);
            session.remove(author);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
