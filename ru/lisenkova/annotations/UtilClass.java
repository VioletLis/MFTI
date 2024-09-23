package ru.lisenkova.annotations;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import ru.lisenkova.tests.TestException;

import static java.lang.System.out;

public class UtilClass {
    public static HashMap<Class<?>,Object> findAllObjects(Class clazz) throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException
    {
            HashMap<Class<?>, Object> result = new HashMap<>();
            Method[] mets = clazz.getDeclaredMethods();
            Constructor obConst = clazz.getDeclaredConstructor();
            obConst.setAccessible(true);
            Object ob = obConst.newInstance();
            for(Method t : mets)
            {
                t.setAccessible(true);
                if(!t.isAnnotationPresent(Invoke.class))
                    continue;
                if(t.getParameterCount()>0)
                    continue;
                result.put(t.getReturnType(),t.invoke(ob,null));
            }
            return result;
    }
    public static List<Field> getAllFields(Class clazz)
    {
        if(clazz.equals(Object.class)) return new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        fields.addAll(List.of(clazz.getDeclaredFields()));
        fields.addAll((getAllFields(clazz.getSuperclass())));
        return fields;
    }
    //7.3.2
    public static void reset(Object... objs) throws Exception {
        for (Object object : objs) //все объекты из списка
        {
            Class<?> clazz = object.getClass();
            List<Field>  fs = getAllFields(clazz); //получены все нужные поля
            for (Field f : fs)  //все поля из списка
            {
                f.setAccessible(true);      //проверка с разными модификаторами доступа
                Default annotation=f.getAnnotation(Default.class);
                if (annotation==null) annotation=clazz.getAnnotation(Default.class);
                if (annotation==null) continue;
                HashMap<Class<?>,Object> defs = findAllObjects(annotation.value()); //получены все нужные значения default
                if(!defs.containsKey(f.getType()))
                { continue;}
                f.set(object,defs.get(f.getType())); //полю установлено значение default
            }
        }
    }
    //7.3.4
    public static void validateDo(Object ... objects) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        try {
            for (Object obj : objects) {
                Validate validation = obj.getClass().getDeclaredAnnotation(Validate.class);
                if (validation == null) continue;
                Class[] clazzesTest = validation.value();
                for (Class testClass : clazzesTest) {
                    Constructor obConst = testClass.getDeclaredConstructor();
                    obConst.setAccessible(true);
                    Object obTest = obConst.newInstance();
                    Method[] testMets = testClass.getDeclaredMethods();
                    for (Method t : testMets) {
                        if (!t.isAnnotationPresent(Validate.class))
                            continue;
                        t.setAccessible(true);
                        t.invoke(obTest, obj);
                    }
                }
            }
        }
        catch (Exception e)
        {
            Throwable throwable = e.getCause();
            if(throwable.getClass() == TestException.class)
                throw (TestException)throwable;
            throw new RuntimeException(e);
        }

    }
    //7.1.4
    public static void  validate(Object obj, Class clazz) throws InstantiationException, IllegalAccessException {
        Method[] mets = clazz.getDeclaredMethods();
        Class<?> clz = clazz.getClass();
        Object obTest = clazz.newInstance();
        for(Method met:mets)
        {
            met.setAccessible(true);
            if(met.getParameterCount()==1)
            {
                try
                {
                    met.invoke(obTest,obj);
                } catch (Exception e) {
                    throw new RuntimeException(e.getCause());
                }
            }
        }
    }
    //7.1.6
    @SuppressWarnings("unchecked")
    public static <T> T cache(T object)
    {
        T t= (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new CacheHandler(object));
        return t;
    }

}//7.3.6
class CacheHandler implements InvocationHandler {
    Map<Method,Object> cache = new HashMap<>();
    Object obj;
    public CacheHandler(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method met = obj.getClass().getMethod(method.getName(),method.getParameterTypes());

        if(met.isAnnotationPresent(Mutator.class)) cache.clear();
        if(!met.isAnnotationPresent(Cache.class))
            return met.invoke(obj,args);
        if(cache.containsKey(met)) return cache.get(met);
        Object result = method.invoke(obj, args);
        cache.put(met,result);
        return result;
    }
}
