package ru.lisenkova.tools;

public class Storage <T> implements MySupplier<T>
{
    private T object;
    private MySupplier<T> mySupplier;
    private Storage(MySupplier<T> tMySupplier)
    {
        this.mySupplier = tMySupplier;
    }

    public static <V> Storage<V> create(MySupplier<V> tMySupplier){
        return new Storage<>(tMySupplier);

    }
    @Override
    public T get(T t)
    {
        if (this.object == null)
            object=mySupplier.get(t);
        return object;
    }
}
