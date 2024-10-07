package ru.lisenkova.annotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import static ru.lisenkova.annotations.UtilClass.findAllObjects;
import static ru.lisenkova.annotations.UtilClass.getAllFields;

public class Resetter {
    public UtilClass util;

    public void reset(Object... objs) throws Exception {
        for (Object object : objs) //все объекты из списка
        {
            Class<?> clazz = object.getClass();
            List<Field> fs = getAllFields(clazz); //получены все нужные поля
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
}
