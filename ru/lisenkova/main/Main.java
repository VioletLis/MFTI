package ru.lisenkova.main;

import ru.lisenkova.annotations.*;
import ru.lisenkova.geometry.Point;
import ru.lisenkova.geometry.PolyLine;
import ru.lisenkova.tests.MakeTests;
import ru.lisenkova.tools.Storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //Стримы-------------------------------------------------------------
        class YPointPositive implements Function<Point, Point> {
            @Override
            public Point apply(Point point) {
                if(point.getY()<0)
                    point.setY(-point.getY());
                return point;
            }
        }
        PolyLine pline= Stream.of(new Point(3,4), new Point(3, 4),
                                    new Point(-3,4), new Point(3, -5),
                               new Point(6,3), new Point(0,-12))
                               .sorted((x,y)->x.getX()-y.getX())
                               .map(new YPointPositive())
                               .distinct()
                               .collect(()->new PolyLine(),(newline,point)->newline.add(point),
                                         (newline1,newline2)->{throw new RuntimeException();});
        out.println(pline);
        //создание файла
        File file = new File("students.data");
        Writer wr = new FileWriter(file.getName());
        wr.write("Вася:3\r\nПетЯ:5\r\nАРИЯ:G\r\nаНя:3\r\nТимур:12");
        wr.flush();
        wr.close();
        //чтение
        Scanner  sc = new Scanner(file);
        Map<String,List<String>> stream = Stream.generate(()->null)
                .takeWhile(x-> sc.hasNext())
                .map(x->sc.next())        //takeWhile до sc.next, чтобы не потерять последний элемент
                .filter(x->x.split(":")[1].matches(".*\\d.*"))
                .map(x->x.toLowerCase())
                .map(x->(x.charAt(0)+"").toUpperCase()+x.substring(1))
                .collect(groupingBy(x->x.split(":")[1]));
        out.println(stream);
        //Аннотации-------------------------------------------------------------------
        out.println(InvokeAnnotationProcesser.collect(Ainvoke.class)); //7.3.1
        AA aa = new AA();
        UtilClass.reset(aa); //7.3.2
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
    public String toString() {
        return "AA{" + "s=" + s + ",x=" + x + ",AA=" + a + ",ob=" + ob + "}";
    }
}

