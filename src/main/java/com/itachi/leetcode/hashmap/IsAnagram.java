package com.itachi.leetcode.hashmap;


import java.util.Arrays;
import java.util.HashMap;

//242. 有效的字母异位词
public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        for (int i = 0; i < sCharArray.length; i++) {
            if (sCharArray[i] != tCharArray[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这是一个字符到整数的转换。'a' 在 ASCII 中的值是 97，因此 s.charAt(i) - 'a' 会将字符 s.charAt(i) 转换为一个整数，这个整数表示该字符在字母表中的索引。例如：
     * 'a' 转换为 0
     * 'b' 转换为 1
     * 'c' 转换为 2
     * 依此类推，直到 'z' 转换为 25。
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            table[index] = table[index] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            table[index] = table[index] - 1;
            if (table[index] < 0) {
                return false;
            }
        }
        return true;
    }

}



