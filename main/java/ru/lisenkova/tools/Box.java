package ru.lisenkova.tools;
//5.1.1
public class Box<T> {
    private T object;

    private Box(T object)
    {
        this.object = object;
    }
    public static <V> Box<V> create(V v)
    {
        return new Box<>(v);
    }


    public T get()
    {
        T tmp = object;
        this.object = null;
        return tmp;
    }
    public void set(T object)
    {
        if (isOccupied(this.object))
            throw new IndexOutOfBoundsException("The box is full");
        this.object = object;
    }
    private boolean isOccupied(T object)
    {
        return  !(object == null);
    }

    @Override
    public String toString() {
        return "Box{" +
                "object=" + object +
                '}';
    }

}
