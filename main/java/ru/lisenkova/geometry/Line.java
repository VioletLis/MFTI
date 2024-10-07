package ru.lisenkova.geometry;

import java.util.Objects;

public class Line<T extends Point> implements Lengthable, Cloneable
{
    //private int x1, y1, x2, y2;
    private T start, end;
    private Line(T start, T end)
    {
        setStart(start);
        setEnd(end);
    }
    public static<K extends Point> Line<K> create(K start, K end)
    {
        return new Line<>(start, end);
    }
    public static Line<Point> create(int x1, int y1, int x2, int y2)
    {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        return new Line<>(start, end);
    }
    public static Line<Point3D> create(int x1, int y1, int z1, int x2, int y2, int z2)
    {
        Point3D start = new Point3D(x1, y1, z1);
        Point3D end = new Point3D(x2, y2, z2);
        return new Line<>(start, end);
    }

    public int length()
    {
        return (this.start).lengthTo(this.end);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass()!= obj.getClass()) return false;
        Line a = (Line) obj;
        return Objects.equals(this.start,a.start) && Objects.equals(this.end,a.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
    @Override
    public Line<T> clone() {
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

    public T getStart()
    {
        return start;
    }
    public T getEnd()
    {
        return end;
    }

    public void setStart(T startNew)
    {
        if (startNew == null) throw new IllegalArgumentException("Line can't have null-elements");
        this.start = (T) startNew.clone();
    }

    public void setEnd(T endNew)
    {
        if (endNew == null) throw new IllegalArgumentException("Line can't have null-elements");
        this.end = (T) endNew.clone();
    }

    @Override
    public String toString()
    {
        return "Линия от "+start.toString()+" до "+end.toString();
    }
}
