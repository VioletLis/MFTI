package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("black")
public class Black implements Color{
    @Autowired
    @Qualifier("bYellow")
    Color next;

    public Color next() {
        return next;
    }
    @Override
    public String toString()
    {
        return "черный";
    }
}
