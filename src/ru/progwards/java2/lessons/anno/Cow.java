//package ru.progwards.java2.lessons.anno;
//
//public class Cow extends Animal {
//    public double milk;
//
//    public Cow(double weight, String name, double milk) {
//        super(weight, name);
//        this.milk = milk;
//    }
//
//    /**
//     *
//     * @throws RuntimeException корова не летает
//     */
//    @Override
//    public void fly() throws RuntimeException {
//        throw new RuntimeException("Я корова и не умею летать");
//    }
//
//    /**
//     *
//     * @return удойность
//     * @exception  ArithmeticException вес коровы должен быть полож
//     */
//    @Deprecated
//    public double milkForWeght() {
//        if (weight <= 0)
//            throw new ArithmeticException("У коровы не может быть вес " + weight);
//        return milk / weight;
//    }
//}
