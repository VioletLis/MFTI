package ru.lisenkova.spring;

import org.springframework.context.annotation.Configuration;

@Configuration
interface Color{
    Color next();
}

