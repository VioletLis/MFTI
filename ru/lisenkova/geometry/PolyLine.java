package ru.lisenkova.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PolyLine implements Lengthable, Cloneable
{
    List<Point2D> list;

    public PolyLine(List<Point2D> list)
    {
        this.list = new ArrayList<>(list);
    }
    public PolyLine()
    {
        this(new ArrayList<Point2D>());
    }

    public void add(Point2D... points)
    {
        this.list.addAll(List.of(points));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PolyLine polyLine)) return false;
        if (this.list.size() != polyLine.list.size()) return false;
        return Objects.equals(list, polyLine.list);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(list);
    }

    @Override
    public PolyLine clone() {
        try {
            PolyLine res = (PolyLine) super.clone();
            res.list = new ArrayList<>();
            for(int i=0;i<this.list.size();i++)
            {
                res.list.add(this.list.get(i).clone());
            }
            return res;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public int length()
    {
        int res=0;
        for (int i=0;i<list.size()-1;i++)
        {
            res+=list.get(i).lengthTo(list.get(i+1));
        }
        return res;
    }


@Override
public String toString()
    {
        return "PolyLine{" + list + "}";
    }


}
