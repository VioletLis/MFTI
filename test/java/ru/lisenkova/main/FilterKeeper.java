package ru.lisenkova.main;

import java.util.ArrayList;
import java.util.List;

public class FilterKeeper<T> implements Keeper<T>{
    private Filter<T> filter;
    private List<T> list = new ArrayList<>();
    public FilterKeeper(Filter<T> filter){
        this.filter = filter;
    }
    @Override
    public void apply(T action) {
        if (filter.test(action)){
            list.add(action);
        }
    }

    @Override
    public List<T> GetList() {
        return list;
    }
}
