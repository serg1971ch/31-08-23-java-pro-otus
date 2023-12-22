package ru.otus;


import java.time.LocalDateTime;

public class Demo {
    public void action() {
//        TestLogging testLogging = Ioc.createMyClass();
//        testLogging.calculation(6);
        new TestLoggingImpl().calculation(6);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Demo().action();
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime-startTime) + " мс");
    }
}

