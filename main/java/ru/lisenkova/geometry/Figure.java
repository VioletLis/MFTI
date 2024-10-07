package ru.lisenkova.geometry;

abstract public class Figure implements Areaable
{
    Point point;
    //int[] side;

    public Figure(Point point)
    {
        this.point = new Point(point.getX(), point.getY());
    }

    public abstract double area();
}








