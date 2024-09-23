package ru.lisenkova.geometry;

public class Square extends Figure
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

