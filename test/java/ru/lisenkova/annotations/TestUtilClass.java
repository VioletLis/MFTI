package ru.lisenkova.annotations;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtilClass extends UtilClass{
    public static HashMap<Class<?>,Object> findAllObjects(Class clazz) throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException
    {
        HashMap<Class<?>, Object> result = new HashMap<>();
        Method[] mets = clazz.getDeclaredMethods();
        Object ob = clazz.newInstance(); // test3: как статик так и нет
        for(Method t : mets)
        {
            t.setAccessible(true);
            if(!t.isAnnotationPresent(Invoke.class))  //test3: только с аннотацией Invoke
                continue;
            result.put(t.getReturnType(),t.invoke(ob)); //test3: ключ-тип метода и значение должно быть ожидаемым
        }
        return result;
    }
    public static List<Field> getAllFields(Class clazz)
    {
        if(clazz.equals(Object.class)) return new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        fields.addAll(List.of(clazz.getDeclaredFields()));    //test1
        fields.addAll((getAllFields(clazz.getSuperclass()))); //test2
        return fields;
    }
    //7.3.2
    public static void reset(Object... objs) throws Exception {
        for (Object object : objs)
        {
            Class<?> clazz = object.getClass();
            List<Field>  fs = getAllFields(clazz);
            for (Field f : fs)
            {
                f.setAccessible(true);      // test 4: проверка с разными модификаторами доступа
                Default annotation=f.getAnnotation(Default.class); //test4 аннотация на поле
                if (annotation==null) annotation=clazz.getAnnotation(Default.class); //test4 аннотация на классе
                if (annotation==null) continue;
                HashMap<Class<?>,Object> defs = findAllObjects(annotation.value());
                if(!defs.containsKey(f.getType())) //test 4
                { continue;}
                f.set(object,defs.get(f.getType())); // test 4 полю установлено значение default
            }
        }
    }
    //7.3.4
    public static void validateDo(Object ... objects) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            for (Object obj : objects) {
                Validate validation = obj.getClass().getDeclaredAnnotation(Validate.class);
                if (validation == null) continue; // test 10: без аннотации Validate у объекта, переход к следующему
                Class[] clazzesTest = validation.value();
                for (Class testClass : clazzesTest) {
                    Constructor obConst = testClass.getDeclaredConstructor();
                    obConst.setAccessible(true);
                    Object obTest = obConst.newInstance();
                    Method[] testMets = testClass.getDeclaredMethods();
                    for (Method t : testMets) {
                        t.setAccessible(true); // test 9: проверка с разными модификаторами доступа
                        try {
                            t.invoke(obTest, obj);  //test 9
                        }catch (InvocationTargetException e)
                        {
                            Throwable throwable = e.getCause(); // test 11
                            throw new RuntimeException(throwable);
                        }catch (IllegalAccessException err)
                        {
                            throw new RuntimeException(err);
                        }
                    }
                }
            }

    }
    @SuppressWarnings("unchecked")
    public static <T> T cache(T object)
    {
        T t= (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new ru.lisenkova.annotations.CacheHandler<>(object));
        return t;
    }

}
//7.3.6
class CacheHandler<T> implements InvocationHandler {
    public Map<Method,Object> cache = new HashMap<>();
    public T obj;
    public CacheHandler(T obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method met = obj.getClass().getMethod(method.getName(),method.getParameterTypes());
        if(method.isAnnotationPresent(Mutator.class))  //test 6, test 8
            cache.clear();
        if(!method.isAnnotationPresent(Cache.class))   //test 7
            return method.invoke(obj,args);
        if(cache.containsKey(method))                  //test 5
            return cache.get(method);
        Object result = method.invoke(obj, args);
        cache.put(method,result);                      //test 5
        return result;
    }
}
