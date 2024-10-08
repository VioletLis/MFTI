package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class ConfigRandom {
    private List<Integer> lstRand = new ArrayList<>();

    @Bean
    @Scope("prototype")
    int random(@Qualifier("min")int min, @Qualifier("max")int max){
        Random random = new Random();
        int x =random.nextInt(min,max);
        if(lstRand.size() == max-min+1) {
            lstRand.clear();
        }
        while (lstRand.contains(x)){
            x = random.nextInt(min,max);
        }

        lstRand.add(x);
        return x;
    }
}
