package com.mac.dna.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(new Integer[]{4, 73, 67, 38, 33});
        System.out.println(gradingStudents(integers));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream().map(integer -> integer < 37 ? integer : integer % 5 > 2 ? Integer.valueOf(integer + 5 - integer % 5) : integer).collect(Collectors.toList());
    }
}
