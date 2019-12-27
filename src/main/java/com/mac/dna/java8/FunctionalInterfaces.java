package com.mac.dna.java8;

public class FunctionalInterfaces {
    public static void main(String[] args) {
       Converter<String, Integer> converter = from -> Integer.valueOf(from);


        Integer converted = converter.convert("123");
        System.out.println(converted);

        MyInterface myInterface = val -> val == 10;
        System.out.println(myInterface.authorize(10));
        System.out.println(myInterface.authorize("10"));
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

@FunctionalInterface
interface MyInterface {

    boolean authorize(int val);

    default boolean authorize(String value) {
        return true;
    }
}