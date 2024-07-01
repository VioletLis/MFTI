package ru.lisenkova.geometry;

public class Point
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
    public String toString()
    {
        return "{" + this.x + "; " + this.y + "}";
    }

}
