package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static ru.otus.Service.runMethod;

public class RunnerImpl implements Runner{

    @Override
    public  <T> void run(Class<ClassTest> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method[] allMethods = clazz.getDeclaredMethods();

        Method[] beforeArray = Arrays.stream(allMethods).filter(method -> method.isAnnotationPresent(Before.class)).toArray(Method[]::new);
        Method[] testArray = Arrays.stream(allMethods).filter(method -> method.isAnnotationPresent(Test.class)).toArray(Method[]::new);
        Method[] afterArray = Arrays.stream(allMethods).filter(method -> method.isAnnotationPresent(After.class)).toArray(Method[]::new);

        int countTest = testArray.length;
        int countSuccessTest = 0;
        int countFailedTest = 0;

        for (Method testMethod : testArray) {

            var invoker = clazz.getDeclaredConstructor().newInstance();

            try {
                for (Method beforeMethod : beforeArray) {
                    runMethod(beforeMethod, invoker);
                }
                try {
                    runMethod(testMethod, invoker);
                    countSuccessTest++;
                } catch (RuntimeException e) {
                    countFailedTest++;
                }
            } finally {
                for (Method afterMethod : afterArray) {
                    try {
                        runMethod(afterMethod, invoker);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Всего тестов: " + countTest +
                            ", Тестов не пройдено: " + countFailedTest +
                            ",  Успешно пройденно тестов: " + countSuccessTest);
    }
}
