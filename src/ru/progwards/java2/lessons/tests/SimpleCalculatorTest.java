package ru.progwards.java2.lessons.tests;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SimpleCalculatorTest {
    static SimpleCalculator calc;
    public int val1;
    public int val2;
    public int ex;

    public SimpleCalculatorTest(int val1, int val2, int ex) {
        this.val1 = val1;
        this.val2 = val2;
        this.ex = ex;
    }
    @BeforeClass
    public static void init() {
        calc = new SimpleCalculator();
        System.out.println("Инициализация объекта");
        System.out.println("Инициализация объекта");
    }
//    @Test
//    public void sum() {
//        assertEquals("Метод sum: проверка не пройдена", calc.sum(0, 0), 0);
//        assertEquals( "Метод sum: проверка не пройдена", calc.sum(Integer.MAX_VALUE, -1), Integer.MAX_VALUE - 1);
//        assertEquals( "Метод sum: проверка не пройдена", calc.sum(Integer.MIN_VALUE, 1), Integer.MIN_VALUE + 1);
//        System.out.println("Метод sum: проверка пройдена");
//    }
//
//
//    @Test
//    public void diff() {
//        assertEquals( "Метод sum: проверка не пройдена", calc.sum(0, 0), 0);
//        assertEquals( "Метод sum: проверка не пройдена", calc.sum(Integer.MAX_VALUE, 1), Integer.MAX_VALUE - 1);
//        assertEquals( "Метод sum: проверка не пройдена", calc.sum(Integer.MIN_VALUE, -1), Integer.MIN_VALUE + 1);
//        System.out.println("Метод sum: проверка пройдена");
//    }
    @Parameterized.Parameters(name = "Test {index}:  ({0}) +({1})  = {2}")
    public static Iterable<Object[]> dataForMultiTest() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 2, 0},
                {50, 20, 1000}
        });
    }
    @Test
    public void multiTest() {
        assertEquals(ex, calc.multi(val1, val2));
    }

    @Parameterized.Parameters(name = "Test {index}:  ({0}) +({1})  = {2}")
    public static Iterable<Object[]> dataForDivTest() {
        return Arrays.asList(new Object[][]{
                {0, 1, 0},
                {10, 5, 2},
                {100, 10, 10},
                {50, 20, 2}
        });
    }
    @Test
    public void divTest() {
        assertEquals(ex, calc.div(val1, val2));
    }

    @AfterClass
    public static void destroy() {
        calc = null;
        System.out.println("Тесты завершены");
    }
}