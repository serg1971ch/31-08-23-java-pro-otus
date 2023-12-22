package ru.otus;

import java.util.Arrays;

 class  TestLoggingImpl implements TestLogging {
    @LogTest
    @Override
    public TestLogging calculation(Object... param) {
        System.out.println(Arrays.toString(param).replace("[", "").replace("]", ""));
        return null;
    }
}
