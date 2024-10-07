package ru.lisenkova.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.function.Predicate;

import static java.lang.Math.abs;

@Configuration
public class BeansConfig {
    List<Integer> lstRand = new ArrayList<>();
    @Bean
    String bean1()
    {
        return "Hello, world";
    }
    @Bean
    @Scope("prototype")
    int random1()
    {
        int res;
         res = (int) (Math.random()*(max()-min()+1)+min());
         while (lstRand.contains(res))
         {
             if(lstRand.size()==abs(max()-min()+1))
             {
                 lstRand.clear();
                 break;
             }
             res = (int) (Math.random()*(max()-min()+1)+min());
         }
         lstRand.add(res);
         return res;
    }
    @Bean
    @Scope("singleton")
    Date bean3()
    {
        return new Date();
    }
    @Bean
    @Scope("prototype")
    Predicate<Integer> bean4(int number)
    {
        Predicate<Integer> res = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (number >= 2) && (number <= 5);
            }
        };
        return res;
    }
    @Bean
    int max()
    {
        return 10;
    }
    @Bean
    int min()
    {
        return 1;
    }
}
