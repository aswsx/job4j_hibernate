package ru.job4j;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class HbmRun {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            /**
             * Даннный код использовался в другом задании
             */
           /*
           Car car = Car.of("Toyota", new Timestamp(1459510232000L), "Sidorov Ivan");
            session.save(car);
            */

            /**
             * Данный участок кода создает три объекта типа Candidate и записывает их в таблицу
             */
    /*
            Candidate firstCandidate = Candidate.of("Alex",
                    new Timestamp(1124031212015L), "50000");
            Candidate secondCandidate = Candidate.of("Max",
                    new Timestamp(1203031032021L), "65000");
            Candidate thirdCandidate = Candidate.of("John",
                    new Timestamp(1657178109000L), "32000");
            session.save(firstCandidate);
            session.save(secondCandidate);
            session.save(thirdCandidate);

 */

            /**
             * Данный код выводит на экран все содержимое таблицы. Запрос выполняется не обращением к таблице, а
             * обращением к объектам Candidate
             */
            Query showAllQuery = session.createQuery("from Candidate");
            for (Object cand : showAllQuery.list()) {
                System.out.println(cand);
            }

            /**
             * данный код удаляет все содержимое таблицы
             */
/*
            session.createQuery("delete from Candidate").executeUpdate();
 */
            showUniqueById(session);
            /**
             * Данный код изменяет поля кандидата с заданным id в таблицы
             */
            Query updateQuery = session.createQuery("update Candidate c set c.name = :newName, c.salary = :newSalary "
                    + "where c.id = :fId");
            updateQuery.setParameter("newName", "Nick");
            updateQuery.setParameter("newSalary", "28500");
            updateQuery.setParameter("fId", 50);
            updateQuery.executeUpdate();

            showUniqueById(session);

            /**
             * Данный код создает нового кандидата на основе существующего
             */
            session.createQuery("insert into Candidate (name, salary, experience) "
                    + "select concat(c.name, 'NEW'), c.salary, c.experience  "
                    + "from Candidate c where c.id = :fId")
                    .setParameter("fId", 50)
                    .executeUpdate();

            /**
             * Данный код выводит уникального кандидата с заданным name из таблицы
             */
            Query showUniqueByNameQuery = session.createQuery("from Candidate c where c.name = :name")
                    .setParameter("name", "NickNEW");
            System.out.println(showUniqueByNameQuery.list());

            /**
             * Данный код удаляет уникального кандидата с заданным id из таблицы
             */
            session.createQuery("delete from Candidate c where c.id = :fId")
                    .setParameter("fId", 51).executeUpdate();

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    /**
     * Данный код выводит уникального кандидата с заданным id из таблицы
     * Выполнен в виде отдельного метода во избежание дублирования кода
     */
    private static void showUniqueById(Session session) {
        Query showUniqueByIdQuery = session.createQuery("from Candidate c where c.id = 50");
        System.out.println(showUniqueByIdQuery.uniqueResult());
    }
}
