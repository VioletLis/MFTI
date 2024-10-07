package ru.lisenkova.spring;

import org.springframework.stereotype.Component;

@Component

public class RYellow implements Color {
    @Override
    public Color next() {
        return new Green();
    }
    @Override
    public String toString()
    {
        return "желтый";
    }
}
