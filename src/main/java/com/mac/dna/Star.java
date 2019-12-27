package com.mac.dna;

import java.util.stream.IntStream;

public class Star {
    public static void main(String[] args) {
        IntStream.range(0, 5).forEachOrdered(i -> {
            IntStream.range(0, i * 3).mapToObj(j -> "*").forEach(System.out::print);
            System.out.println();
        });
    }
}
