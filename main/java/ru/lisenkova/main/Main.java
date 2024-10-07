package ru.lisenkova.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lisenkova.annotations.*;
import ru.lisenkova.spring.Random;
import ru.lisenkova.spring.TrafficLight;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("ru.lisenkova.spring");
        Object ob1 = ac.getBean("bean1");
        out.println(ob1);
//        Object ob2 = ac.getBean("random");
//        out.println(ob2);
//        Object ob3=ac.getBean("random");
//        out.println(ob3);
        Object ob4=ac.getBean("bean3");
        out.println(ob4);
        Object ob5=ac.getBean("bean4",7);
        out.println(ob5);
        TrafficLight tr = ac.getBean(TrafficLight.class);
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        Random ob6 = (Random) ac.getBean("random");
        out.println(ob6.getRandom());
        out.println(ob6.getRandom());

        //Аннотации-------------------------------------------------------------------
        out.println(InvokeAnnotationProcesser.collect(Ainvoke.class)); //7.3.1
        AA aa = new AA();
      //  UtilClass.reset(aa); //7.3.2
        out.println(aa);

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

