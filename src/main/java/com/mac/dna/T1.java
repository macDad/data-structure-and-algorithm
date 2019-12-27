package com.mac.dna;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T1 {
    public static void main(String[] args) {

        int [] arr = new int [] {1,1,1,2,3,2,1,1};

        Map<Integer,Integer> asd = new HashMap<Integer, Integer>();
        for (int value : arr) {
            asd.put(value, asd.get(value) == null ? 1 : asd.get(value) + 1);
        }
        int count = asd.keySet().stream().mapToInt(key -> asd.get(key) / 2).sum();

        System.out.println(" pair" + count);
    }

}
