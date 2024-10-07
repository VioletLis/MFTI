package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansColor{
    @Bean
    public Color gyellow()
    {
        return new GYellow();
    }
    @Bean
    public Color ryellow()
    {
        return new RYellow();
    }
    @Bean
    public Color red()
    {
        return new Red();
    }
    @Bean
    @Qualifier("first")
    public Color green()
    {
        return new Green();
    }
}
