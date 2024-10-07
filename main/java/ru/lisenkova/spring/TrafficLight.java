package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight{
   // @Autowired
   @Autowired
   @Qualifier("first")
   Color color;

    public void setColor(Color color)
    {
        this.color = color;
    }
    public void next()
    {
        System.out.println(color.toString());
       setColor(color.next());

        color.next();
    }
}
