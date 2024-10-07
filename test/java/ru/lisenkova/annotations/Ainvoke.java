package ru.lisenkova.annotations;

public class Ainvoke {
        public Ainvoke(){};
        @Invoke
        String m1()
        {
            return "text";
        }
        String m2()
        {
            return "place";
        }
        @Invoke
        Integer m3()
        {
            return 42;
        }
}

