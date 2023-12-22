package ru.otus;

import java.lang.reflect.InvocationTargetException;

public class Launcher {
    public static void run(Class<ClassTest> clazz) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Runner runner = new RunnerImpl();
        runner.run(clazz);
    }
}
