package ru.lisenkova.geometry;

public class Triangle extends Figure
{
    private final Point p2, p3;

    public Triangle(Point p1, Point p2, Point p3)
    {
        super(p1);
        checkSides(p1,p2,p3);
        this.p2 = new Point(p2.getX(),p2.getY());
        this.p3 = new Point(p3.getX(),p3.getY());
    }
    public void checkSides(Point p1, Point p2, Point p3) // сумма длин двух сторон треугольника должна быть строго больше длины третьей
    {
        double a,b,c;
        a = Math.sqrt(Math.pow(p1.getX()- p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2));
        b = Math.sqrt(Math.pow(p1.getX()- p3.getX(),2)+Math.pow(p1.getY()-p3.getY(),2));
        c = Math.sqrt(Math.pow(p2.getX()- p3.getX(),2)+Math.pow(p2.getY()-p3.getY(),2));
        if ((a + b <= c) || (a + c <= b) || (b + c <= a))
            throw new IllegalArgumentException("This triangle cannot exist");
    }

    @Override
    public double area()
    {
        //   S = 1/2 * |(x2-x1)*(y3-y1)-(x3-x1)*(y2-y1)|
        double res = (this.p2.getX()-this.point.getX())*(this.p3.getY()-this.point.getY());
        res -= (this.p3.getX()-this.point.getX())*(this.p2.getY()-this.point.getY());
        res = Math.abs(res) / 2;
        return res;
    }
}