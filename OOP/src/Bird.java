import java.util.Random;

abstract class Bird
{

    private String song;
    abstract void sing();


}

class Sparrow extends Bird
{
    private final String song ="чырык";

    public Sparrow()
    {
        super();
    }

    @Override
    public void sing()
    {
        System.out.println(song);
    }
}

class Cuckoo extends Bird
{
    private  final String song = "ку-ку";

    public Cuckoo()
    {
        super();
    }
    @Override
    public void sing()
    {
        int quantity=(int)(Math.random()*10+1);
        String res="";
        for (int i=0; i<quantity;i++)
        {
            res += song+" ";
        }
        System.out.println(res);
    }
}
class Parrot extends Bird
{
    String song;

    public Parrot(String song)
    {
        super();
        this.song = song;
    }
    public void setSong(String song) {
        this.song = song;
    }

   // @Override
    public void sing()
    {
        int quantity=(int)(Math.random()*(song.length()-1-1));
        System.out.println(song.substring(0,quantity));
    }
}