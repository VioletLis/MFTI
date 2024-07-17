package ru.lisenkova.geometry;
import java.util.List;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(List<Point2D> list)
    {
        super(list);
    }
    public ClosedPolyLine()
    {
    }

    @Override
    public int length()
    {
        int res = super.length();
        if ((list==null)||(list.size()<3))
            return res;
        return res+list.get(list.size() - 1).lengthTo(list.get(0));
    }

    @Override
    public String toString() {
        return "ClosedPolyLine{" + list + "}";

    }
}
