package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class Random {
    private List<Integer> lstRand = new ArrayList<>();

    public Random() {
    }

    int random(){
        java.util.Random random = new java.util.Random();
        int x =random.nextInt(0,100);
        if(lstRand.size() == 101) {
            lstRand.clear();
        }
        while (lstRand.contains(x)){
            x = random.nextInt(0,100);
        }

        lstRand.add(x);
        return x;
    }
    public int getRandom()
    {
        return random();
    }


}
