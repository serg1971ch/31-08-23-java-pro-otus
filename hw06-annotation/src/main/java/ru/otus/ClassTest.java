package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class ClassTest {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Launcher.run(ClassTest.class);
    }

    @Before
    public void setUp(){
        System.out.println("@Before_Экземпляр тестового класса: " + hashCode());
    }

    @Test
    public void someTest1(){
        System.out.println("Test1_Экземпляр тестового класса: " + hashCode());
    }

    @Test
    public void someTest2(){
        System.out.println("Test2_Экземпляр тестового класса: " + hashCode());
    }

    @After
    public void tearDown(){
        System.out.println("tearDown_Экземпляр тестового класса: " + hashCode() + "\n");
    }
}
