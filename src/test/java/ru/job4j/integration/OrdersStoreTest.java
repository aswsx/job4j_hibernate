package ru.job4j.integration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class OrdersStoreTest {
    private final BasicDataSource pool = new BasicDataSource();

    @BeforeEach
    public void setUp() throws SQLException {
        pool.setDriverClassName("org.hsqldb.jdbcDriver");
        pool.setUrl("jdbc:hsqldb:mem:tests;sql.syntax_pgs=true");
        pool.setUsername("sa");
        pool.setPassword("");
        pool.setMaxTotal(2);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("./db/scripts/update_001.sql")))
        ) {
            br.lines().forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool.getConnection().prepareStatement(builder.toString()).executeUpdate();
    }

    @AfterEach
    public void destroy() throws SQLException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("./db/scripts/update_002.sql")))
        ) {
            br.lines().forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool.getConnection().prepareStatement(builder.toString()).executeUpdate();
    }

    @Test
    void whenSaveOrderAndFindAllOneRowWithDescription() {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        List<Order> all = (List<Order>) store.findAll();
        assertThat(all.size()).isEqualTo(1);
        assertThat(all.get(0).getDescription()).isEqualTo("description1");
        assertThat(all.get(0).getId()).isEqualTo(1);
    }

    @Test
    void whenUpdateDatabase() {
        OrdersStore store = new OrdersStore(pool);
        Order order = (Order.of("name1", "description1"));
        Order newOrder = (Order.of("name2", "description2"));
        store.save(order);
        store.update(newOrder, order.getId());
        assertThat(store.findById(order.getId()).getName()).isEqualTo("name2");
    }

    @Test
    void whenFindByName() {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        Order order = store.findByName("name1");
        assertThat(order.getName()).isEqualTo("name1");
    }

    @Test
    void whenFindById() {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        Order order = store.findById(1);
        assertThat(order.getName()).isEqualTo("name1");
    }
}