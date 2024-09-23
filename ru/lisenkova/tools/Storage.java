package ru.lisenkova.tools;

import java.util.Optional;
import java.util.function.Supplier;

public class Storage <T> implements MySupplier<T>
{
    private T object;
    private MySupplier<T> mySupplier;
    private Storage(T t)
    {
        this.object = t;
    }

    public static <V> Storage<V> create(V v){
        return new Storage<>(v);

    }
    @Override
    public T get(T t)
    {
        if (this.object == null)
            object=mySupplier.get(t);
        return object;
    }
}
