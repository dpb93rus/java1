package ru.progwards.java2.lessons.tests;

public class SimpleCalculator {

    public int sum (int val1, int val2){
        long result = (long)val1 + (long)val2;
        if (result > Integer.MAX_VALUE||result < Integer.MIN_VALUE)
            throw new ArithmeticException("Ответ вне границ допустимого диапазона");
        return (int)result;
    }
    public int diff(int val1, int val2) {
        long result = (long)val1 - (long)val2;
        if (result > Integer.MAX_VALUE||result < Integer.MIN_VALUE)
            throw new ArithmeticException("Ответ вне границ допустимого диапазона");
        return (int)result;
    }
    public int multi(int val1, int val2) {
        long result = (long)val2 * (long)val1;
        if (result > Integer.MAX_VALUE||result < Integer.MIN_VALUE)
            throw new ArithmeticException("Ответ вне границ допустимого диапазона");
        return (int)result;
    }
    public int div(int val1, int val2) {
        long result = (long)val1 / (long)val2;
        if (val2 == 0 || result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            throw new ArithmeticException("Ответ вне границ допустимого диапазона");
        return (int)result;
    }

    public static void main(String[] args) {
        SimpleCalculator a = new SimpleCalculator();
        System.out.println(a.sum(20,924324323));

    }
}









//package ru.progwards.java2.lessons.tests.main.java;
//
//
//        import org.jetbrains.annotations.Contract;
//        import org.junit.AfterClass;
//        import org.junit.BeforeClass;
//        import org.junit.Test;
//        import org.junit.runners.Parameterized;
//
//        import java.util.Arrays;
//
//        import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SimpleCalculatorTest {
//    static SimpleCalculator calc;
//    public int val1;
//    public int val2;
//    public int ex;
//
//    public SimpleCalculatorTest(int val1, int val2, int ex) {
//        this.val1 = val1;
//        this.val2 = val2;
//        this.ex = ex;
//    }
//
//    @BeforeClass
//    public static void init() {
//        calc = new SimpleCalculator();
//        System.out.println("Инициализация объекта");
//    }
//
//    @Test(timeout = 500, expected = ArithmeticException.class)
//    public void sum() {
//        assertEquals(calc.sum(0, 0), 0, "Метод sum: проверка не пройдена");
//        assertEquals(calc.sum(Integer.MAX_VALUE, -1), Integer.MAX_VALUE - 1, "Метод sum: проверка не пройдена");
//        assertEquals(calc.sum(Integer.MIN_VALUE, 1), Integer.MIN_VALUE + 1, "Метод sum: проверка не пройдена");
//        System.out.println("Метод sum: проверка пройдена");
//
//    }
//
//    @Test
//    public void diff() {
//        assertEquals(calc.sum(0, 0), 0, "Метод sum: проверка не пройдена");
//        assertEquals(calc.sum(Integer.MAX_VALUE, 1), Integer.MAX_VALUE - 1, "Метод sum: проверка не пройдена");
//        assertEquals(calc.sum(Integer.MIN_VALUE, -1), Integer.MIN_VALUE + 1, "Метод sum: проверка не пройдена");
//        System.out.println("Метод sum: проверка пройдена");
//    }
//
//    @Contract(pure = true)
//    @Parameterized.Parameters
//    public static Iterable<Integer[]> dataForMultTest() {
//        return Arrays.asList(new Integer[][]{
//                {0, 0, 0},
//                {1, 1, 1},
//                {0, 2, 0},
//                {50, 20, 1000}
//        });
//    }
//
//    @Test
//    public void multiTest() {
//        assertEquals(ex, calc.mult(val1, val2));
//    }
//
//    @Test
//    public void div() {
//    }
//
//    @AfterClass
//    public static void destroy() {
//        calc = null;
//        System.out.println("Тесты завершены");
//    }
//}