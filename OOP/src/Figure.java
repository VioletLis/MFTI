import java.util.List;

interface IAreaAble {
    abstract double area();
}


abstract class Figure implements IAreaAble
{
    Point point;
    //int[] side;

    public Figure(Point point)
    {
        this.point = new Point(point.getX(), point.getY());
    }

    public abstract double area();
}
class Circle extends Figure
{
    private final int radius;
    public Circle(Point point,int radius)
    {
        super(point);
        if (radius <= 0)
                throw new IllegalArgumentException("Radius of circle must be positive");
        this.radius=radius;
    }
    @Override
    public double area()
    {
        return Math.PI*this.radius*this.radius;
    }
}


class Square extends Figure
{
    private final int side;
    public Square(Point point, int side)
    {
        super(point);
        if (side <= 0)
                throw new IllegalArgumentException("Side of square must be positive");
        this.side=side;
    }
    @Override
    public double area()
    {
        return side*side;
    }
}

class Rectangle extends Figure
{
    private final int width, length;
    public Rectangle(Point point, int width, int length)
    {
        super(point);
        if ((width <= 0) ||(length<=0))
                throw new IllegalArgumentException("Sides of rectangle must be positive");
        this.width=width;
        this.length=length;
    }
    @Override
    public double area()
    {
        return this.width*this.length;
    }
}
class Triangle extends Figure
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




