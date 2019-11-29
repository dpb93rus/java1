package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num = 0;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String result = "";
        int c = 0;
        while (c < 8) {
            if ((num & 1) == 1)
                result = ("1" + result);
            else
                result = ("0" + result);
            num >>= 1;
            c++;
        }

            return result;

        }
        public static void main (String[]args){
            Binary bin = new Binary((byte) 127);
            System.out.println(bin);

        }
    }

