package com.itachi.leetcode.hashmap;

//383. 赎金信
public class CanConstruct {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        //canConstruct(ransomNote, magazine);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            table[index] = table[index] + 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            table[index] = table[index] - 1;
            if (table[index] < 0) {
                return false;
            }
        }
        return true;
    }

}
