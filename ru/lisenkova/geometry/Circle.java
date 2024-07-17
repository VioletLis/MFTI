package ru.lisenkova.geometry;

public class Circle extends Figure
{
    private final int radius;
    public Circle(Point2D point, int radius)
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