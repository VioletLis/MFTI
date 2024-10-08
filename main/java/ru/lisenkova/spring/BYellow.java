package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bYellow")
public class BYellow implements Color {
    @Autowired
    @Qualifier("black")
    Color next;

    public Color next() {
        return next;
    }
    @Override
    public String toString()
    {
        return "желтый";
    }
}
