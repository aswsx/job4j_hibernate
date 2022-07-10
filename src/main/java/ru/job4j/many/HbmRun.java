package ru.job4j.many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 10/07/2022 - 17:46
 */
public class HbmRun {

    public static void main(String[] args) {
        /*
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            User one = User.of("Petr");
            session.save(one);

            Role admin = Role.of("ADMIN");
            admin.addUser(session.load(User.class, 1));

            session.save(admin);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }

         */
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            CarModel one = CarModel.of("Corolla");
            session.save(one);
            CarModel two = CarModel.of("Camry");
            session.save(two);
            CarModel three = CarModel.of("Tundra");
            session.save(three);
            CarModel four = CarModel.of("LC");
            session.save(four);
            CarModel five = CarModel.of("RAV4");
            session.save(five);

            CarBrand brand = CarBrand.of("Toyota");
            brand.addModel(session.load(CarModel.class, 1));
            brand.addModel(session.load(CarModel.class, 2));
            brand.addModel(session.load(CarModel.class, 3));
            brand.addModel(session.load(CarModel.class, 4));
            brand.addModel(session.load(CarModel.class, 5));

            session.save(brand);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}