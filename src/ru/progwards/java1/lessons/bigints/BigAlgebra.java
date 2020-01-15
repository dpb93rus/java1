package ru.progwards.java1.lessons.bigints;
import java.math.BigInteger;
import java.math.BigDecimal;
public class BigAlgebra {
   static BigDecimal fastPow(BigDecimal num, int pow){
        if (pow==0) return BigDecimal.ONE;
        if (pow==1) return num;
        int n = 1;
        BigDecimal res = new BigDecimal("1");
        while( n <= pow) {
            res = num.multiply(res) ;
            n++;
        }
        return res;
    }

    static BigInteger fibonacci(int n){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("1");
        BigInteger z = new BigInteger("0");
        int count = 1;
        while (n != count) {
            z = x;
            x = y;
            y = y.add(z);
            count++;
        }
        return y;
    }



    public static void main(String[] args) {

        System.out.println (fastPow(new BigDecimal("54564564565465475474"), 45));
        System.out.println (fibonacci(9));
    }

}
