package com.mac.DnA;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    static int MAX_CHAR = 26;

    public static void main(String[] args) throws Exception {
        System.out.println(new CustomSortString().customSortString("cba", "bcaacbdafhabc"));
        System.out.println(new CustomSortString().customSortString2("cba", "bcaacbdafhabc"));
        char a = 'a';
        char b = 'b';
        char c = 'c';
        System.out.println(a - a);
        System.out.println(a - c);
        char[] pat = "bca".toCharArray();
        char[] str = "bcaacbdafhabc".toCharArray();
        sortByPattern(str, pat);
        //System.out.println(String.valueOf(str));
    }

    // Sort str according to the order defined by pattern.
    static void sortByPattern(char[] str, char[] pat) {
        // Create a count array stor
        // count of characters in str.
        int[] count = new int[MAX_CHAR];

        // Count number of occurrences of
        // each character in str.
        for (int i = 0; i < str.length; i++) {
            count[str[i] - 'a']++;
        }

        // Traverse the pattern and print every characters
        // same number of times as it appears in str. This
        // loop takes O(m + n) time where m is length of
        // pattern and n is length of str.
        int index = 0;
        for (int i = 0; i < pat.length; i++) {
            for (int j = 0; j < count[pat[i] - 'a']; j++) {
                str[index++] = pat[i];
            }
        }
    }

    //This is ok
    public String customSortString2(String S, String T) {
        char[] pat = S.toCharArray();
        char[] input = T.toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder(input.length);
        for (char c : input) {
            if (S.indexOf(c) >= 0) charCountMap.merge(c, 1, Integer::sum);
            else stringBuilder.append(c);
        }
        for (int i = pat.length - 1; i >= 0; i--) {
            Integer charCount = charCountMap.get(pat[i]);
            if (charCount > 0) {
                for (int j = 0; j < charCount; j++) {
                    stringBuilder.insert(0, pat[i]);
                }
            }
        }

        return stringBuilder.toString();
    }

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            if (!map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), 1);
            } else {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.remove(c);
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
            }
        }
        for (char c : map.keySet()) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
