package ru.lisenkova.tools;

import java.util.Optional;

public class Storage <T>
{
    private final T object;
    private Storage(T object)
    {
        this.object = object;
    }
    public static <V> Storage<V> create(V v){
        return new Storage<>(v);

    }
    public T get(T t)
    {
        if (object != null) return object;
        return t;
    }

}
