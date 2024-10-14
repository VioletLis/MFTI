package ru.lisenkova.bases;


import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSelector {
    @Autowired
    static Connection connection;
    public static void openConnectin(){
        try {
            connection = DriverManager.getConnection("jdbc:h2:.\\Office");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> findAll(Class<T> clz) {
        openConnectin();
        Field fields[]=clz.getDeclaredFields();
        String statementText;
        if(clz.getAnnotation(Table.class)!=null)
            statementText="Select * from " + clz.getAnnotation(Table.class).name();//getSimpleName();
        else statementText="Select * from " + clz.getSimpleName();
        List<T> resList= new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet res= statement.executeQuery(statementText);
            while(res.next()) {
                T resObject = clz.newInstance();
                resList.add(resObject);
                for (Field f : fields) {
                    f.setAccessible(true);
                    if(f.getAnnotation(Column.class)!=null)
                        f.set(resObject,res.getObject(f.getAnnotation(Column.class).name(),f.getType()));
                    else f.set(resObject,res.getObject(f.getName(),f.getType()));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  resList;
    }
}
