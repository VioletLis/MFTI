import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Figure circle1 = new Circle(new Point(1,1), 1);
        Figure circle2 = new Circle(new Point(0,0),1);
        Figure square1 = new Square(new Point(2,1),1);
        Figure square2 = new Square(new Point(3,0),1);
        System.out.println(sumArea(new Figure[]{circle1, circle2, square1, square2})); //в этом частном случае PI+PI+1+1 =~8.28

        Line line1 = new Line(new Point(1,1), new Point(1,0));
        Line line2 = new Line(new Point(1,1), new Point(0,1));
        PolyLine line3 = new PolyLine(List.of(new Point(0,0), new Point(1,0), new Point(1,4)));
        System.out.println(sumLength(new Ilengther[]{line1,line2,line3})); //в этом частном случае 1+1+1+4=7

    }
    public static double sumArea(IAreaAble[] objects) //3.3.3
    {
        double res=0;
        if (objects.length==0) return 0;
        for(int i=0;i<objects.length; i++ )
            res+=objects[i].area();
        return res;
    }

    public static double sumLength(Ilengther[] objects) //3.3.5
    {
        double res=0;
        if (objects.length==0) return 0;
        for(int i=0;i<objects.length; i++ )
            res+=objects[i].length();
        return res;
    }
}
