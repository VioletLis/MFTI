package ru.lisenkova.animals;

public class Cuckoo extends Bird
{


    public Cuckoo()
    {
        super();
    }
    @Override
    public String getSong()
    {
        int quantity=(int)(Math.random()*10+1);
        String res = "";
        for (int i=0; i<quantity; i++)
        {
            res += "ку-ку ";
        }
        return res;
    }
}
