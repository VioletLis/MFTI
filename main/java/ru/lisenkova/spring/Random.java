package ru.lisenkova.spring;

import java.util.ArrayList;
import java.util.List;

public class Random {
    List<Integer> lstRand = new ArrayList<>();

    public Random() {
    }

    public int random()
    {
        int res;
        res = (int) (Math.random()*101);
        while (lstRand.contains(res))
        {
            if(lstRand.size()==101)
            {
                lstRand.clear();
                break;
            }
            res = (int) (Math.random()*101);
        }
        lstRand.add(res);
        return res;
    }
    public int getRandom()
    {
        return random();
    }

}
