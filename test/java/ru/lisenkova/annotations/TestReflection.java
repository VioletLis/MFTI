package ru.lisenkova.annotations;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReflection {

    @Test
    @DisplayName("Find fields in class by UtilClass.getAllFields")
    @SneakyThrows
     void test1() throws Exception
    {
        UtilClass utilClass = new TestUtilClass();
        List<Field> fields = utilClass.getAllFields(MonkeyOrigin.class);
        List<Field> expectedFields = new ArrayList<>();
        expectedFields.add(MonkeyOrigin.class.getDeclaredField("str"));
        expectedFields.add(MonkeyOrigin.class.getDeclaredField("str2"));

        Assertions.assertTrue(fields.containsAll(expectedFields));
    }
    @Test
    @DisplayName("Find fields in superclass by UtilClass.getAllFields")
    @SneakyThrows
    void test2 () throws Exception
    {
        UtilClass utilClass = new TestUtilClass();
        List<Field> fields = utilClass.getAllFields(MonkeyOrigin.class);
        List<Field> expectedFields = new ArrayList<>();

        expectedFields.add(MonkeyDad.class.getDeclaredField("st"));
        expectedFields.add(MonkeyDad.class.getDeclaredField("y"));

        expectedFields.add(MonkeyGranny.class.getDeclaredField("height"));
        expectedFields.add(MonkeyGranny.class.getDeclaredField("obj"));

        Assertions.assertTrue(fields.containsAll(expectedFields));
    }
    @Test
    @DisplayName("Invoke all methods from class by UtilClass.findAllObjects")
    @SneakyThrows
    void test3 () throws Exception
    {
        UtilClass utilClass = new TestUtilClass();
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
        UtilClass utilClass = new TestUtilClass();
        MonkeyReset monkey = new MonkeyReset();
        MonkeyReset monkeyExpected =
                new MonkeyReset(42,99,-100,"hello",42,null);
        utilClass.reset(monkey);
        Assertions.assertEquals(monkey,monkeyExpected);
    }

    @Test
    @DisplayName("Methods was cached by utilClass.cache")
    @SneakyThrows
    void test5 () throws Exception
    {
        TestUtilClass utilClass = new TestUtilClass();
        MonkeyCacheable cacheMonkey1 = new CacheMonkey1();
        cacheMonkey1 = utilClass.cache(cacheMonkey1);
        cacheMonkey1.getHeight();
        cacheMonkey1.getHeight();
        cacheMonkey1.getHeight();
        cacheMonkey1.getName();
        cacheMonkey1.getName();
        cacheMonkey1.getName();

        Assertions.assertTrue(cacheMonkey1.toString().equals("1 invoke getHeight: 170, 1 invoke getName: Vasya"));
    }
    @Test
    @DisplayName("When @Mutator clear cache")
    @SneakyThrows
    void test6 () throws Exception
    {
        TestUtilClass utilClass = new TestUtilClass();
        MonkeyCacheable cacheMonkey1 = new CacheMonkey1();
        cacheMonkey1 = utilClass.cache(cacheMonkey1);
        cacheMonkey1.getHeight();
        cacheMonkey1.getName();
        cacheMonkey1.setHeight(100);
        cacheMonkey1.getHeight();
        Assertions.assertTrue(cacheMonkey1.toString().equals("1 invoke getHeight: 100, 0 invoke getName: Vasya"));
    }

    @Test
    @DisplayName("Without @Cache standard invoke method")
    @SneakyThrows
    void test7 () throws Exception
    {
        TestUtilClass utilClass = new TestUtilClass();
        MonkeyCacheable cacheMonkey1 = new CacheMonkey1();
        cacheMonkey1 = utilClass.cache(cacheMonkey1);
        cacheMonkey1.setHeight(100);
        cacheMonkey1.setName("Petya");
        Assertions.assertTrue(cacheMonkey1.toString().equals("0 invoke getHeight: 100, 0 invoke getName: Petya"));
    }

    @Test
    @DisplayName("Do not clear cache without @Mutator")
    @SneakyThrows
    void test8 () throws Exception
    {
        TestUtilClass utilClass = new TestUtilClass();
        MonkeyCacheable cacheMonkey1 = new CacheMonkey1();
        cacheMonkey1 = utilClass.cache(cacheMonkey1);
        cacheMonkey1.getName();
        cacheMonkey1.setName("Petya");
        Assertions.assertTrue(cacheMonkey1.toString().equals("0 invoke getHeight: 170, 1 invoke getName: Petya"));
    }

    @Test
    @DisplayName("Validation")
    @SneakyThrows
    void test9 () throws Exception
    {
        TestUtilClass utilClass = new TestUtilClass();
        MonkeyValidate1 monkeyValidate1 = new MonkeyValidate1();
        utilClass.validateDo(monkeyValidate1);
        Assertions.assertDoesNotThrow (()->"Too small for human");
        Assertions.assertDoesNotThrow (()->"Too tall for a human");
        Assertions.assertDoesNotThrow (()->"Name can't contain numbers");
        Assertions.assertDoesNotThrow (()->"Name must contains only alphabets");
    }
    @Test
    @DisplayName("No validatin without @Validate")
    @SneakyThrows
    void test10 () throws Exception
    {
        TestUtilClass utilClass = new TestUtilClass();
        MonkeyValidate1 monkeyValidate1 = new MonkeyValidate1();
        MonkeyValidate2 monkeyValidate2 = new MonkeyValidate2();
        utilClass.validateDo(monkeyValidate1, monkeyValidate2);
        Assertions.assertDoesNotThrow (()->"Too small for human");
        Assertions.assertDoesNotThrow (()->"Too tall for a human");
        Assertions.assertDoesNotThrow (()->"Name can't contain numbers");
        Assertions.assertDoesNotThrow (()->"Name must contains only alphabets");
    }
    @Test
    @DisplayName("Throw exception when constrain validation")
    @SneakyThrows
    void test11 () throws Exception
    {
        TestUtilClass utilClass = new TestUtilClass();
        MonkeyValidate3 monkeyValidate3 = new MonkeyValidate3();
        //utilClass.validateDo(monkeyValidate4);
        RuntimeException exception = Assertions.assertThrowsExactly(RuntimeException.class,()->utilClass.validateDo(monkeyValidate3));
        Assertions.assertEquals(exception.getMessage(),"java.lang.RuntimeException: Too small for a human");
    }




}
