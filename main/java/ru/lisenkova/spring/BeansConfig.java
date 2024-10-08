package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.function.Predicate;

import static java.lang.Math.abs;

@Configuration
public class BeansConfig {
    List<Integer> lstRand = new ArrayList<>();
    @Bean
    String hellow()
    {
        return "Hello, world";
    }
    @Bean
    @Lazy
    Date date()
    {
        return new Date();
    }
    @Bean
    Predicate<Integer> rule() {
        return x -> (x >= 2) && (x <= 5);
    }
    @Bean
    @Qualifier("max")
    int max()
    {
        return 10;
    }
    @Bean
    @Qualifier("min")
    int min()
    {
        return 1;
    }
}
