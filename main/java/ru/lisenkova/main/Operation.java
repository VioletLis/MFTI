package ru.lisenkova.main;

public interface Operation <T,V>{
    V apply(T t);
}
