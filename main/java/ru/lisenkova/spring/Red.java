package ru.lisenkova.spring;

import org.springframework.stereotype.Component;

@Component
public class Red implements Color{

    @Override
    public Color next() {
        return new RYellow();
    }
    @Override
    public String toString()
    {
        return "красный";
    }
}
