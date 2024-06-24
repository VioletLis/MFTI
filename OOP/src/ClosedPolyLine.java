import java.util.ArrayList;
import java.util.List;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(List<Point> list)
    {
        super(list);
    }
    public ClosedPolyLine()
    {
    }

    private double lengthTo(Point p1, Point p2)
    {
        double res=0;
        res=Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()- p2.getY(),2));
        return res;
    }
    @Override
    public double length()
    {
        return super.length()+lengthTo(list.getLast(),list.getFirst());
    }

    @Override
    public String toString() {
        return "ClosedPolyLine{" + list + "}";

    }
}
