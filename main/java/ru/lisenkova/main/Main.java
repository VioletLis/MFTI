package ru.lisenkova.main;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.lisenkova.annotations.*;
import ru.lisenkova.bases.DBSelector;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class Main {
    @Bean
    DataSource dataSource()
    {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:.\\\\Office");
        return jdbcDataSource;

    }
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Main.class);
        EmployeeRepo repo = ctx.getBean(EmployeeRepo.class);
        List<EmployeeBD> emps = repo.findAll();
        emps.forEach(System.out::println);
        List<Employee> empsSel = DBSelector.findAll(Employee.class);
        empsSel.forEach(System.out::println);
        List<EmployeeBD> empsSelBD = DBSelector.findAll(EmployeeBD.class);
        empsSelBD.forEach(System.out::println);
     

    }
}

@Default(Config.class)
class AA {
    String s;
    int x;
    AA a;
    Object ob;
    @Override
    @Invoke
    public String toString() {
        return "AA{" + "s=" + s + ",x=" + x + ",AA=" + a + ",ob=" + ob + "}";
    }
}

