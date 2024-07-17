package ru.lisenkova.geometry;

import java.util.Objects;

public class Point3D extends Point2D implements Cloneable{
    private int z;
    public Point3D(int x, int y, int z)
    {
        super(x,y);
        this.z = z;
    }
    public  void setX(int x) {super.setX(x);}
    public  void setY(int y) {super.setY(y);}
    public void setZ(int x)
    {
        this.z = z;
    }
    public int getZ()
    {
        return z;
    }

    public int lengthTo(Point3D target)
    {
        int i1=this.getX() - target.getX();
        int i2=this.getY() - target.getY();
        int i3=this.getZ() - target.getZ();
        int res=i1*i1 + i2*i2 + i3*i3;
        return (int) Math.round(Math.sqrt(res));
    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if(obj == null || getClass()!= obj.getClass()) return false;
//        Point a = (Point) obj;
//        return  (this.x == a.x && this.y == a.y);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    @Override
    public Point3D clone() {
        Point3D res = (Point3D) super.clone();
        return res;

    }
//    @Override
//    public Point clone()  {
//        try {
//            Point res = (Point) super.clone();
//            return res;
//        }
//        catch (CloneNotSupportedException e)
//        {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public String toString()
    {
        return "{" + super.getX() + "; " + super.getY() + "; " + z + "}";
    }

}
