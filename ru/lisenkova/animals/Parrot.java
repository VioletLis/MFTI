package ru.lisenkova.animals;

import java.util.Random;

public class Parrot extends Bird
{
    private final String song;

    public Parrot(String song)
    {
        this.song = song;
    }

    @Override
    public String getSong()
    {
        int length=new Random().nextInt(song.length()+1);
        return song.substring(0,length);
    }
}