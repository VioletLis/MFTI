package ru.lisenkova.annotations;

import org.springframework.stereotype.Component;

@Component
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
class A
{
    int x=111;
}
class Config2 {
    @Invoke
    int defForInt() {return 99;}

    String defForString() {return "bye";}

}

