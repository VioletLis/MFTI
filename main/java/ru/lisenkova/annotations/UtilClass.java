package ru.lisenkova.annotations;

import ru.lisenkova.tests.TestException;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UtilClass {
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
               // HashMap<Class<?>,Object> defs = findAllObjects(annotation.value());
                HashMap<Class<?>,Object> defs = findAllObjects(annotation.value());
                if(!defs.containsKey(f.getType())) //test 4
                { continue;}
                f.set(object,defs.get(f.getType())); // test 4 полю установлено значение default
            }
        }
    }
    //7.3.4
    public static void validateDo(Object ... objects) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        try {
            for (Object obj : objects) {
                Validate validation = obj.getClass().getDeclaredAnnotation(Validate.class);
                if (validation == null) continue; // без аннотации Validete у объекта, переход к следующему
                Class[] clazzesTest = validation.value();
                for (Class testClass : clazzesTest) {
                    Constructor obConst = testClass.getDeclaredConstructor();
                    obConst.setAccessible(true);
                    Object obTest = obConst.newInstance();
                    Method[] testMets = testClass.getDeclaredMethods();
                    for (Method t : testMets) {
                        if (!t.isAnnotationPresent(Validate.class)) //без аннотации Validate переход к следующему классу
                            continue;
                        t.setAccessible(true); // проверка с разными модификаторами доступа
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
                (InvocationHandler) new CacheHandler(object));
        return t;
    }

}
