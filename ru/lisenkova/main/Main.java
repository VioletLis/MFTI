package ru.lisenkova.main;

import ru.lisenkova.math.Fractionable;
import ru.lisenkova.tools.DataStream;

import java.util.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        List<String> lst = List.of("1", "22", "4", "a");
        int res = DataStream.create(lst)
                .filter(x -> Character.isDigit(x.charAt(0))) //time O(1)
                .map(Integer::parseInt) //time O(1)
                .reduction(Integer::sum)
                .orElse(0);
        out.println(res);
    }
}

