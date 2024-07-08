package ru.lisenkova.main;
import ru.lisenkova.geometry.*;
import ru.lisenkova.geometry.Point;
import ru.lisenkova.math.Fraction;
import ru.lisenkova.work.City;
import ru.lisenkova.work.Road;

import static java.lang.System.out;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        Line line1 = new Line(new Point(1,1), new Point(1,0));
        Line line2 = new Line(new Point(1,1), new Point  (0,1));
        Line line3 = line1.clone();
        out.println(line1.equals(line2));
        out.println(line1.equals(line1));
        out.println(line1.equals(line3));
        line3.setEnd(1,1);
        out.println(line1.toString());
        out.println("-----------------------------");
        PolyLine polyline1 = new PolyLine(List.of(new Point(0,0), new Point(1,0), new Point(1,4)));
        PolyLine polyline2 = new PolyLine(List.of(new Point(1,0), new Point(1,0), new Point(1,4)));
        PolyLine polyline3 = polyline1.clone();
        out.println(polyline1.equals(polyline2));
        out.println(polyline1.equals(polyline1));
        out.println(polyline1.equals(polyline3));
        polyline3.add(new Point(10,11));
        out.println(polyline1.toString());
        out.println(polyline3.toString());
        out.println("-----------------------------");
        Point point1 = new Point(3,5);
        Point point2 = new Point(5,5);
        Point point3 = point2.clone();
        out.println(point1.equals(point1));
        out.println(point1.equals(point2));
        out.println(point2.equals(point3));
        out.println("-----------------------------");
        Fraction fraction1 = new Fraction(3,5);
        Fraction fraction2 = new Fraction(5,5);
        Fraction fraction3 = fraction2.clone();
        out.println(fraction1.equals(fraction2));
        out.println(fraction3.equals(fraction2));
        out.println(fraction2.equals(fraction3));
        out.println("-----------------------------");
        City city1 = new City("L1");
        City city2 = new City("L2");
        Road road1 = new Road(city2,3);
        City city3 = city1.clone();
        out.println(city1.equals(city3));
        City city4 = city3.clone();
        out.println(city4.equals(city3));
        city1.removeRoad(city1);
        city3.addRoad(road1);
        out.println(city1.equals(city3));

    }

}
