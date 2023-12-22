package ru.otus;

import java.lang.reflect.Method;

public class Service {

    static Object runMethod(Method method, Object obj, Object... args){
        try {
            return method.invoke(obj, args);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
