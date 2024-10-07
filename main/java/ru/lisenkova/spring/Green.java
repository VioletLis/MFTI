package ru.lisenkova.spring;

import org.springframework.stereotype.Component;

@Component
class Green implements Color{

    @Override
    public Color next() {
        return new GYellow();
    }
    @Override
    public String toString()
    {
        return "зеленый";
    }
}
