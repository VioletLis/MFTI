public class Line
{
    //private int x1, y1, x2, y2;
    private Point start, end;

    Line(int x1, int y1, int x2, int y2)
    {
        this.start= new Point(x1,y1);
        //this.start.setY(y1);
        this.end=new Point(x2,y2);
        //this.end.setY(y1);
    }


    Line(Point A1, Point A2)
    {
        this.start = new Point(A1.getX(), A1.getY());
        this.end = new Point(A2.getX(), A2.getY());
    }
    public int length()
    {
        int res=0;
        res = (int) Math.round(Math.sqrt(Math.pow((start.getX()-end.getX()), 2) + Math.pow((start.getY()-end.getY()), 2)));
        return res;

    }

    public Point getStart()
    {
        return new Point(start.getX(), start.getY());
    }
    public Point getEnd()
    {
        return new Point(end.getX(), end.getY());
    }

    public void setStart(Point startNew)
    {
        start.setX(startNew.getX());
        start.setY(startNew.getY());
    }
    public void setStart(int x1,int y1)
    {
        start.setX(x1);
        start.setY(y1);
    }
    public void setEnd(int x2,int y2)
    {
        end.setX(x2);
        end.setY(y2);
    }

    public void setEnd(Point endNew)
    {
        end.setX(endNew.getX());
        end.setY(endNew.getY());
    }

    @Override
    public String toString()
    {
        return "Линия от {"+start.getX()+";"+start.getY()+"} до {"+end.getX()+";"+end.getY()+"}";
    }
}
