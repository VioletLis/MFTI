package ru.lisenkova.annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
//7.3.6
public class CacheHandler implements org.springframework.cglib.proxy.InvocationHandler {
    Map<Method,Object> cache = new HashMap<>();
    Object obj;
    public CacheHandler(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method met = obj.getClass().getMethod(method.getName(),method.getParameterTypes());

        if(met.isAnnotationPresent(Mutator.class)) cache.clear(); //сброс кэша при выполнении метода с аннотацией Mutator
        if(!met.isAnnotationPresent(Cache.class))
            return met.invoke(obj,args);
        if(cache.containsKey(met)) {System.out.println("99");return cache.get(met);}
        Object result = method.invoke(obj, args);
        cache.put(met,result);
        return result;
    }
}