package ru.lisenkova.animals;

public abstract class Bird
{
    public void sing()
    {
        System.out.println(getSong());
    }
    public abstract String getSong();

}




