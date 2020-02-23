package ru.progwards.dpb;

import java.io.IOException;

public class EX {
    public void test(int n) throws IOException {
        try {
            doSomething(n);
        } catch (IOException r) {
            r.getMessage();
            throw r;
        }
        finally {
            System.out.println("finally executed");
        }
    }

    public void doSomething(int n) throws IOException {
        n++;
    }
}
