package ru.lisenkova.main;

import java.util.ArrayList;
import java.util.List;

public class MapKeeper<T> implements Keeper<T> {
    private Operation<T,T> operation;
    private List<T> list = new ArrayList<>();

    public MapKeeper(Operation<T,T> operation)
    {
        this.operation = operation;
    }
    @Override
    public void apply(T action)
    {
        list.add(operation.apply(action));
    }

    @Override
    public List<T> GetList() {
        return list;
    }
}
