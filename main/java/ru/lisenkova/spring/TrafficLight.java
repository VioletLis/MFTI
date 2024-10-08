package ru.lisenkova.spring;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("TrafficLight")
public class TrafficLight{
   // @Autowired
   @Autowired
   @Qualifier("red")
   private Color color;
   @Autowired
   @Qualifier("red")
   private Color base;
   @Autowired
   @Qualifier("black")
   private Color waitingColor;

    public void setColor(Color color)
    {
        this.color = color;
    }
    public void next()
    {
        System.out.println(color.toString());
        setColor(color.next());

    }
    public void waiting(){
        color=waitingColor;
    }
    @PostConstruct
    public void on()
    {
        color = base;
    }
}
