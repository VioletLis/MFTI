package ru.lisenkova.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lisenkova.annotations.*;
import ru.lisenkova.spring.TrafficLight;

import java.sql.*;

import static java.lang.System.out;
import static ru.lisenkova.bases.DBCreationScript.createDB;

public class Main {
    public static void main(String[] args) throws Exception {

//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("ru.lisenkova.spring");
//        Object ob1 = ac.getBean("hellow");
//        out.println(ob1);
//        Object ob2 = ac.getBean("random");
//        out.println(ob2);
//        Object ob3=ac.getBean("random");
//        out.println(ob3);
//        Object ob4=ac.getBean("date");
//        out.println(ob4);
//        Object ob5=ac.getBean("rule",7);
//        out.println(ob5);
//        TrafficLight tr = ac.getBean(TrafficLight.class);
//        tr.next();
//        tr.next();
//        tr.next();
//        tr.next();
//        tr.waiting();
//        tr.next();
//        tr.next();
//        tr.on();
//        tr.next();
//        tr.next();
//        tr.next();
//        //-------------------------database
        Class.forName("org.h2.Driver");
        createDB();
        try(Connection connection = DriverManager.getConnection("jdbc:h2:.\\Office")) {
            //Statement stm = connection.createStatement();
            PreparedStatement statementprep = connection.prepareStatement("Select id, name from Employee where id>?");
            statementprep.setInt(1,2);
            //ResultSet results = stm.executeQuery("Select id, name from Employee where id>?"+2);
           ResultSet results = statementprep.executeQuery();
            while (results.next()){
                out.println(results.getInt("ID")+" "+results.getString("name"));
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException();
        }

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

