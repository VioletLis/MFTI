package ru.lisenkova.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
@Qualifier("gYellow")
public class GYellow implements Color {
        @Autowired
        @Qualifier("red")
        Color next;

        public Color next() {
            return next;
        }
        @Override
        public String toString()
        {
            return "желтый";
        }
}