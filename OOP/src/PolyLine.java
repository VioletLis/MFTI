import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Ilengther
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


    public double length()
    {
        double res=0;
        for (int i=0;i<list.size()-1;i++)
        {
            res+=lengthTo(list.get(i),list.get(i+1));
        }
        return res;
    }

    private double lengthTo(Point p1, Point p2)
    {
        double res=0;
        res=Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()- p2.getY(),2));
        return res;
    }

@Override
public String toString()
    {
        return "PolyLine{" + list + "}";
    }


}
