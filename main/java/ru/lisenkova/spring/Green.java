package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("green")
public class Green implements Color{
    @Autowired
    @Qualifier("gYellow")
    Color next;

    public Color next() {
        return next;
    }
    @Override
    public String toString()
    {
        return "зеленый";
    }
}
