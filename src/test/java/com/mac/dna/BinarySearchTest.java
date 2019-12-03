package com.example.DnA;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BinarySearchTest {
    @Test
    void iterativeBinarySearchTest() {
        int[] srr = {2,3,4,1,5,2,3,7,8,9};
        Arrays.sort(srr);
        assertEquals(6,BinarySearch.iterativeBinarySearch (srr,5));
    }

    @Test
    void recursiveBinarySearchTest () {
        int[] arr = {2,3,4,1,5,2,3,7,8,9};
        Arrays.sort(arr);
        assertEquals(6,BinarySearch.recursiveBinarySearch(arr,5, 0, arr.length - 1));
    }
}