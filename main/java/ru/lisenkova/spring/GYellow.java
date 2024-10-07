package ru.lisenkova.spring;

public class GYellow implements Color {
        @Override
        public Color next() {
            return new Red();
        }
        @Override
        public String toString()
        {
            return "желтый";
        }
}
