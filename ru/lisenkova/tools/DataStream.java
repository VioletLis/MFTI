package ru.lisenkova.tools;

import ru.lisenkova.main.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class DataStream<T> {
    private List<T> list;
    private List<Keeper<T>> actions = new ArrayList<>();
    private DataStream(List<T> list)
    {
        this.list = list;
    }
    public static <T> DataStream<T> create(List<T> list)
    {
        return new DataStream<>(list);
    }
    private void adding()
    {
        for (int i = 0; i<actions.size(); i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                actions.get(i).apply(list.get(j));
            }
            list = actions.get(i).GetList();
        }
    }
    public <R> DataStream<R> map(Operation<T, R> operation) //5.3.1
    {
        actions.add(new MapKeeper(operation));
        return (DataStream<R>) this;
    }
    public DataStream<T> filter(Filter<T> filt) //5.3.2
    {
        actions.add(new FilterKeeper<>(filt));
        return this;
    }
    private boolean isEmptyOrNull()
    {
        if ((this.list == null)||(this.list.isEmpty()))
            return true;
        return false;
    }
    public Optional<T> reduction(Summator<T> summator) //5.3.3
    {
        if (isEmptyOrNull())
            return Optional.empty();

        adding();

        if (isEmptyOrNull())
            return Optional.empty();

        T res=list.get(0);
        for (int i=1; i<list.size(); i++)
        {
            res = summator.make(res,list.get(i));
        }
        return Optional.of(res);
    }
    public <P> P collect(CollectionCreator<P> creator, MyCollection<P,T> collector)
    {
       adding();
        P result = creator.create();
        for (T element : list)
        {
            collector.add(result, element);
        }
        return result;
    }

}
