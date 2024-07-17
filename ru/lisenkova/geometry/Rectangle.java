package ru.lisenkova.geometry;

public class Rectangle extends Figure
{
    private final int width, length;
    public Rectangle(Point2D point, int width, int length)
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
