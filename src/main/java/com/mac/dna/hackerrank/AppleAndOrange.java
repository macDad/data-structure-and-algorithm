package com.mac.dna.hackerrank;

import java.util.Arrays;

public class AppleAndOrange {
    public static void main(String[] args) {
        countApplesAndOranges(7, 11, 5, 15, new int[]{-2, 2, 1}, new int[]{5, -6});
    }


    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        System.out.println((int) Arrays.stream(apples).filter(i -> i + a >= s && i + a <= t).count());
        System.out.println((int) Arrays.stream(oranges).filter(i -> i + b >= s && i + b <= t).count());
    }
}