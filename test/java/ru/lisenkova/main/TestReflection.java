package ru.lisenkova.main;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lisenkova.annotations.Config;
import ru.lisenkova.annotations.TestUtilClass;
import ru.lisenkova.annotations.UtilClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReflection {
   // MonkeyReflectionOrigin monkey;

    @Test
    @DisplayName("Find fields in class by UtilClass.getAllFields")
    @SneakyThrows
     void test1() throws Exception
    {
        UtilClass utilClass = new TestUtilClass();
        List<Field> fields = utilClass.getAllFields(MonkeyReflectionOrigin.class);
        List<Field> expectedFields = new ArrayList<>();
        expectedFields.add(MonkeyReflectionOrigin.class.getDeclaredField("str"));
        expectedFields.add(MonkeyReflectionOrigin.class.getDeclaredField("str2"));

        Assertions.assertTrue(fields.containsAll(expectedFields));
    }
    @Test
    @DisplayName("Find fields in superclass by UtilClass.getAllFields")
    @SneakyThrows
    void test2 () throws Exception
    {
        UtilClass utilClass = new UtilClass();
        List<Field> fields = utilClass.getAllFields(MonkeyReflectionOrigin.class);
        List<Field> expectedFields = new ArrayList<>();

        expectedFields.add(MonkeyReflectionDad.class.getDeclaredField("st"));
        expectedFields.add(MonkeyReflectionDad.class.getDeclaredField("y"));

        expectedFields.add(MonkeyReflectionGranny.class.getDeclaredField("height"));
        expectedFields.add(MonkeyReflectionGranny.class.getDeclaredField("obj"));

        Assertions.assertTrue(fields.containsAll(expectedFields));
    }
    @Test
    @DisplayName("Invoke all methods from class by UtilClass.getAllObjects")
    @SneakyThrows
    void test3 () throws Exception
    {
        UtilClass utilClass = new UtilClass();
        Map<Class<?>,Object> map = utilClass.findAllObjects(Config.class);
        Map<Class<?>,Object> expectedMap = new HashMap<>();

        expectedMap.put(int.class, 42);
        expectedMap.put(String.class,"hello");
        expectedMap.put(Double.class, 5.3);
        expectedMap.put(Object.class, null);

        Assertions.assertEquals(expectedMap,map);
    }
    @Test
    @DisplayName("Check state after reset with UtilClass.reset")
    @SneakyThrows
    void test4 () throws Exception
    {
        UtilClass utilClass = new UtilClass();
        MonkeyReflectionReset monkey = new MonkeyReflectionReset();
        MonkeyReflectionReset monkeyExpected =
                new MonkeyReflectionReset(42,99,-100,"hello",42,null);
        UtilClass.reset(monkey);
        Assertions.assertEquals(monkey,monkeyExpected);
    }



}
