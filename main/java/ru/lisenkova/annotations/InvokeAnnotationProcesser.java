package ru.lisenkova.annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
//7.3.1
public class InvokeAnnotationProcesser {
    public static Map<String,Object> collect(Class ... classes) throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException {
        Map<String, Object> result = new HashMap<>();
        for(Class nclass : classes)
        {
            Method[] mets = nclass.getDeclaredMethods();
            Constructor obConst = nclass.getDeclaredConstructor();
            obConst.setAccessible(true);
            Object ob = obConst.newInstance();
            for(Method t : mets)
            {
                t.setAccessible(true);
                if(!t.isAnnotationPresent(Invoke.class))
                    continue;
                if(t.getReturnType()==Void.class)
                    continue;
                if(t.getParameterCount()>0)
                    continue;
                result.put(t.getName(),t.invoke(ob,null));
            }
        }
        return result;
    }
}
