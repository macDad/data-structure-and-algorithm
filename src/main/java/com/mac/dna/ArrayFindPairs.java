package com.mac.dna;

public class ArrayFindPairs {

    /**
     * Input  :  arr[] = {1, 5, 7, -1},
     * sum = 6
     * Output :  2
     * Pairs with sum 6 are (1, 5) and (7, -1)
     * <p>
     * Input  :  arr[] = {1, 5, 7, -1, 5},
     * sum = 6
     * Output :  3
     * Pairs with sum 6 are (1, 5), (7, -1) &
     * (1, 5)
     * <p>
     * Input  :  arr[] = {1, 1, 1, 1},
     * sum = 2
     * Output :  6
     * There are 3! pairs with sum 2.
     * <p>
     * Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6,
     * 5, 4, 2, 1, 1, 1},
     * sum = 11
     * Output :  9
     */
    public static void main(String args[]) {
        int[] arr1 = {1, 5, 7, -1};
        int sum = 6;
        System.out.println(getPairsCount(arr1, sum));


        int[] arr2 = {1, 5, 7, -1, 5};
        sum = 6;
        System.out.println(getPairsCount(arr2, sum));

        int[] arr3 = {1, 1, 1, 1};
        sum = 2;
        System.out.println(getPairsCount(arr3, sum));

        int[] arr4 = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        sum = 11;
        System.out.println(getPairsCount(arr4, sum));

    }

    private static int getPairsCount(int[] arr, int sum) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == sum) ++count;
            }
        }
        return count;
    }
}
