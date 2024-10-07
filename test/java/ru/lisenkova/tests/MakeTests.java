package ru.lisenkova.tests;


import java.lang.reflect.Method;

public class MakeTests {
    public static void makeTests(Class clazz) throws InstantiationException, IllegalAccessException {
        Method[] mets = clazz.getDeclaredMethods();
        Object test = clazz.newInstance();
        for (Method mt : mets)
        {
            try {
                mt.invoke(test);
            }catch (Exception e){
                Throwable th = e.getCause();
                if(th.getClass().equals(TestException.class)){
                    System.out.println(th.getCause() + " в " +mt.getName());
                }
                throw new RuntimeException(e);
            }
        }
    }
}
