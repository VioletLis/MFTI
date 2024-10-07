package ru.lisenkova.main;

import ru.lisenkova.annotations.Config;
import ru.lisenkova.annotations.Default;

public class Main {
    public static void main(String[] args) throws Exception {


    }
}

@Default(Config.class)
class AA {
    String s;
    int x;
    AA a;
    Object ob;
    @Override
    public String toString() {
        return "AA{" + "s=" + s + ",x=" + x + ",AA=" + a + ",ob=" + ob + "}";
    }
}

