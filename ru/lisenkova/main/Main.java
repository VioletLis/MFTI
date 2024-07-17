package ru.lisenkova.main;
import ru.lisenkova.geometry.*;
import ru.lisenkova.geometry.Point2D;
import ru.lisenkova.study.Student;
import ru.lisenkova.tools.Box;
import ru.lisenkova.tools.Storage;
import ru.lisenkova.work.City;
import ru.lisenkova.work.Road;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static ru.lisenkova.main.Methods.*;

public class Main {
    public static void main(String[] args)
    {
        out.println("-----------------------------");
        City city1 = new City("L1");
        City city2 = new City("L2");
        Road road1 = new Road(city2,3);
        City city3 = city1.clone();
        out.println(city1.equals(city3));
        city1.addRoad(road1);
        out.println(city1.equals(city3));
        out.println(city1.toString());
        out.println("-----------------------------5.1.2");
        Storage<Integer> storage1 = Storage.create(null);
        double res = Math.pow(2, storage1.get(0));
        out.println("null: " + res);

        Storage<Integer> storage2 = Storage.create(99);
        res = Math.pow(storage2.get(-1),2);
        out.println("99: " + res);

        Storage<String> storage3 = Storage.create(null);
        out.println("String null: " + storage3.get("default"));

        Storage<String> storage4 = Storage.create("hello");
        out.println("hello: " + storage4.get("hello world"));

        out.println("-----------------------------5.1.3 & 5.1.4");
        Student student1 = new Student("Vasya", 5,5,5,2,4);
        Student student2 = new Student("Ilya", 4,5,5,2,2);
        out.println(student1.compareTo(student2));
        out.println(student1.averageMark());
        out.println(student2.averageMark());
        out.println("----------------------------- 5.2.1");
        Point2D p1 = new Point2D(1, 1);
        Point2D p2 = new Point2D(2, 4);
        Line<Point3D> line1 = Line.create(new Point3D(1,1,9), new Point3D(1,0,0));
        Line<Point2D> line2 = Line.create(p1, p2);
        out.println(line1);
        addStartX(line1);
        out.println(line1.toString());
        out.println(line2.toString());
        addStartX(line2);
        out.println(line2.toString());
        out.println("----------------------------- 5.1.1 & 5.2.2");
        Box<Number> box1 = Box.create(3);
        Box<Double>  box2 = Box.create(14.0);
        Box<Integer> box3 = Box.create(13);
        Box<String>  box4 = Box.create("23.0F");
        out.println("Max box: " + maxBox(box2, box3, box1));
        out.println(box1.get());
        out.println("----------------------------- 5.2.3");
        Box<Point2D> boxP2D = Box.create(null);
        putPoint3D(boxP2D);
        out.println(boxP2D);
        Box<Point3D> boxP3D = Box.create(null);
        putPoint3D(boxP3D);
        out.println(boxP3D);
        out.println("----------------------------- 5.2.4");
        List<Integer> list = new ArrayList<>();
        out.println(list);
        setList(list);
        out.println(list);

        List<Number> list1 = new ArrayList<>();
        out.println(list1);
        putInList(list1);
        out.println(list1);



    }

}
