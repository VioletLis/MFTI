package ru.lisenkova.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestUtilClass extends UtilClass{
    public static HashMap<Class<?>,Object> findAllObjects(Class clazz) throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException
    {
        return new HashMap<>();

    }
    public static List<Field> getAllFields(Class clazz)
    {
        return new ArrayList<>();
    }
}
