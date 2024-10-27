package ru.lisenkova.annotations;

public class Config {
    @Invoke
    private int defForInt() {return 42;}
    @Invoke
    public String defForString1() {return "hello";}
    @Invoke
    public static Double defForDouble() {return 5.3;}
    public static Integer defForInteger() {return 8;}
    @Invoke Object obj(){return null;}

}