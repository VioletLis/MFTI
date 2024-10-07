package ru.lisenkova.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE,ElementType.TYPE_USE,ElementType.ANNOTATION_TYPE})
public @interface Validate {
    Class[] value();
}
