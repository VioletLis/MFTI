package ru.lisenkova.geometry;

import ru.lisenkova.math.Fraction;

import java.util.Objects;

public class Line implements Lengthable, Cloneable
{
    //private int x1, y1, x2, y2;
    private Point start, end;

    public Line(int x1, int y1, int x2, int y2)
    {
        this.start= new Point(x1,y1);
        this.end=new Point(x2,y2);
    }

    public Line(Point A1, Point A2)
    {
        this.start = new Point(A1.getX(), A1.getY());
        this.end = new Point(A2.getX(), A2.getY());
    }
    public int length()
    {
        int res=0;
        res = (int) Math.round(Math.sqrt(Math.pow((start.getX()-end.getX()), 2) + Math.pow((start.getY()-end.getY()), 2)));
        return res;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass()!= obj.getClass()) return false;
        Line a = (Line) obj;
        return this.start.equals(a.start) && this.end.equals(a.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
    @Override
    public Line clone() {
        try {
            Line res = (Line) super.clone();
            res.start = this.start.clone();
            res.end = this.end.clone();
            return res;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Point getStart()
    {
        return new Point(start.getX(), start.getY());
    }
    public Point getEnd()
    {
        return new Point(end.getX(), end.getY());
    }

    public void setStart(Point startNew)
    {
        start.setX(startNew.getX());
        start.setY(startNew.getY());
    }
    public void setStart(int x1,int y1)
    {
        start.setX(x1);
        start.setY(y1);
    }
    public void setEnd(int x2,int y2)
    {
        end.setX(x2);
        end.setY(y2);
    }

    public void setEnd(Point endNew)
    {
        end.setX(endNew.getX());
        end.setY(endNew.getY());
    }

    @Override
    public String toString()
    {
        return "Линия от {"+start.getX()+";"+start.getY()+"} до {"+end.getX()+";"+end.getY()+"}";
    }
}
