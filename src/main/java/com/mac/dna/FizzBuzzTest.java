package com.mac.dna;

import java.util.Optional;

public class FizzBuzzTest {
    public static String fizzBuzz(int number) {
        StringBuffer buffer = new StringBuffer();
        if (number % 3 == 0) {
            buffer.append("fizz");
        }
        if (number % 5 == 0) {
            buffer.append("buzz");
        }
        return buffer.toString();
    }

    public static String fizzBuzzV2(int number) {
        if (number % 15 == 0) {
            return "fizzbuzz";
        } else if (number % 5 == 0) {
            return "buzz";
        } else if (number % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(number);
    }


    public static void testFizzBuzz() {
        System.out.println("fizz : " + fizzBuzz(3));
        System.out.println("buzz : " + fizzBuzz(5));
        System.out.println("fizzbuzz : " + fizzBuzz(15));
        System.out.println("2 : " + fizzBuzz(2));
    }


    public static void testFizzBuzzV2() {
        System.out.println("fizz : " + fizzBuzzV2(3));
        System.out.println("buzz : " + fizzBuzzV2(5));
        System.out.println("fizzbuzz : " + fizzBuzzV2(15));
        System.out.println("2 : " + fizzBuzzV2(2));
    }

    public static void main(String[] args) {
        //  testFizzBuzz();
        // testFizzBuzzV2();
        System.out.println(fizzBuzzInJava8(15));
        System.out.println(fizzBuzzInJava8(2));
        System.out.println(fizzBuzzInJava8(3));

        System.out.println(map(15));
        System.out.println(map(2));
        System.out.println(map(3));
    }

    private static String fizzBuzzInJava8(int number) {
        String result = Optional.of(number).map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : "")).get();
        return result.isEmpty() ? Integer.toString(number) : result;
    }

    public static String map(int n) {
        return (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : "");
    }
}
