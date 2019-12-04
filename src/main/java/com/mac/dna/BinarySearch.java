package com.mac.dna;


public class BinarySearch {

    public static int iterativeBinarySearch(int[] arr, int i) {

        int first = 0;
        int last = arr.length - 1;
        int mid = 0;
        while (first <= last) {
            mid = (first + last) / 2;
            if (arr[mid] < i) {
                first = mid + 1;
            } else if (arr[mid] > i) {
                last = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] srr, int i, int first, int last) {
        if (first > last) return -1;

        int mid = (first + last) / 2;
        if (srr[mid] == i) {
            return mid;
        } else if (srr[mid] > i) {
            return recursiveBinarySearch(srr, i, first, mid - 1);
        } else {
            return recursiveBinarySearch(srr, i, mid + 1, last);
        }

    }
}
