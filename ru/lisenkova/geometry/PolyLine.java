package ru.lisenkova.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Lengthable
{
    List<Point> list;

    public PolyLine(List<Point> list)
    {
        this.list = new ArrayList<>(list);
    }
    public PolyLine()
    {
        this(new ArrayList<Point>());
    }

    public void add(Point ... points)
    {
        this.list.addAll(List.of(points));
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
