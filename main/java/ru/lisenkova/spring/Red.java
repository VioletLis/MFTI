package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("red")
public class Red implements Color{
    @Autowired
    @Qualifier("rYellow")
    Color next;

    public Color next() {
        return next;
    }
    @Override
    public String toString()
    {
        return "красный";
    }
}
