package ru.lisenkova.geometry;

abstract public class Figure implements Areaable
{
    Point2D point;
    //int[] side;

    public Figure(Point2D point)
    {
        this.point = new Point2D(point.getX(), point.getY());
    }

    public abstract double area();
}








