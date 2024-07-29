package ru.lisenkova.tools;

import ru.lisenkova.main.Filter;
import ru.lisenkova.main.Operation;
import ru.lisenkova.main.Summator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Work {
    public static <T,P> List<P> map(List<T> list, Operation<T, P> operation) //5.3.1
    {
        var list1 = new ArrayList<P>();
        for(T t : list)
        {
            list1.add(operation.apply(t));
        }
        return  list1;
    }
    public static <T> List<T> filter(List<T> list, Filter<T> filt) //5.3.2
    {
        var list1 = new ArrayList<T>();
        for (T t: list)
        {
            if (filt.test(t)) list1.add(t);
        }
        return list1;
    }
    public static <T> Storage<T> reduction(List<T> list, Summator<T> summator) //5.3.3
    {
        if ((list == null)||(list.isEmpty()))
            return Storage.create(null);
        T res=list.get(0);
        for (int i=1; i<list.size(); i++)
        {
            res = summator.make(res,list.get(i));
        }
        return Storage.create(res);
    }
    public static <T, P> P collect(List<T> list, Supplier<P> creator, BiConsumer<P,T> collector)
    {
        P result = creator.get();
        for (T element : list)
        {
            collector.accept(result, element);
        }
        return result;
    }
//    public static <T,P> Collection<T> collect(List<T> list, Collector<T,?,P> type)
//    {
//        Collection<T> collection =new ArrayList<T>(list);
//    }
}
