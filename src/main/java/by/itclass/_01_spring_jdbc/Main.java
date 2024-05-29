package by.itclass._01_spring_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {
    public static void main(String[] args) {
//        var dataSource = new DriverManagerDataSource();
        var dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/po_2304");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        var jdbcTemplate = new JdbcTemplate(dataSource);

        var users = jdbcTemplate.query("SELECT id,fio,age FROM users", new UserRowMapping());
        users.forEach(System.out::println);
        System.out.println("******************");

        var ben = jdbcTemplate.query("SELECT id,fio,age FROM users WHERE fio=?", new UserRowMapping(),
                new Object[]{"Ben Smith"}).get(0);
        System.out.println(ben);

        System.out.println("******************");
        jdbcTemplate.update("Update users Set fio=? Where id=?","Ben Claus",4);
        ben = jdbcTemplate.query("SELECT id,fio,age FROM users WHERE id=?", new UserRowMapping(),
                new Object[]{4}).get(0);
        System.out.println(ben);

    }
}
