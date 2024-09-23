package ru.lisenkova.annotations;

public class Config {
    @Invoke
    int defForInt() {return 42;}
    @Invoke
    String defForString() {return "hello";}
    @Invoke
    Class<?> defForClass() {return null;}

}
