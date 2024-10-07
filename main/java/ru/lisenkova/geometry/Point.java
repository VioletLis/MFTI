package ru.lisenkova.geometry;

import java.util.Objects;

public class Point implements Cloneable
{
    private int x,y;
    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int lengthTo(Point target)
    {
        int i1=this.getX() - target.getX();
        int i2=this.getY() - target.getY();
        int res=i1*i1 + i2*i2;
        return (int) Math.round(Math.sqrt(res));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass()!= obj.getClass()) return false;
        Point a = (Point) obj;
        return  (this.x == a.x && this.y == a.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public Point clone()  {
        try {
            Point res = (Point) super.clone();
            return res;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString()
    {
        return "{" + this.x + "; " + this.y + "}";
    }

}
