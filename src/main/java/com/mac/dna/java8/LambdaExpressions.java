package com.mac.dna.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        oldWay();
        newWay();
    }

    private static void oldWay() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names.toString());
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names.toString());
    }

    private static void newWay() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names.toString());
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
        System.out.println(names.toString());
    }
}
