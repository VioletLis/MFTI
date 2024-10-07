package ru.lisenkova.main;

import java.util.List;

public interface Keeper <T>{
    void apply(T action);
    List<T> GetList();
}
