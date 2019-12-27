package com.mac.dna.hackerrank;

public class Kangaroo {
    public static void main(String[] args) {
        System.out.println(kangaroo(0, 3, 4, 2));
        System.out.println(kangaroo(0, 2, 5, 3));
        System.out.println(kangaroo(4523, 8092, 9419, 8076));
        System.out.println(kangaroo(0, 1000, 0, 1000));
    }

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if ((x2 > x1 && v2 > v1) || (x1 > x2 && v1 > v2)) return "NO";
        else {
            while (x1 != x2) {
                x1 = x1 + v1;
                x2 = x2 + v2;
                if (x1 > x2) {
                    break;
                }
            }

            return x1 == x2 ? "YES" : "NO";
        }
    }
}
