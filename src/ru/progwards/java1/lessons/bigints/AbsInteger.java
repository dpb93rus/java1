package ru.progwards.java1.lessons.bigints;
import java.math.BigInteger;
import java.math.BigDecimal;
public class AbsInteger {
    public long n = 0L;
    public AbsInteger (long n){
        this.n = n;
    }
    public static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        long res = num1.n+num2.n;
        if (((long)res) >= -128L && ((long)res) <= 127L)
        return  new ByteInteger((byte)res);
        if ((((long)res) < -128L && ((long)res) >= -32768L) || (((long)res) > 127L && ((long)res) < 32768L))
            return  new ShortInteger((short)res);
        if ((((long)res) < -32768L && ((long)res) >= -2147483648L) || (((long)res) > 32767L && ((long)res) < 2147483648L))
            return  new IntInteger((int)res);
        return  new AbsInteger((long)res);
    }
    @Override
    public String toString() {
        return "AbsInteger{" +
                "n=" + n +
                '}';
    }
    public static void main(String[] args) {
        AbsInteger A1 = new AbsInteger(44L);
        AbsInteger A2 = new AbsInteger(4L);
        System.out.println(add(A1,A2));
    }
}

