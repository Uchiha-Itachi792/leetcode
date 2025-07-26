package com.itachi.leetcode;

import java.util.HashSet;
import java.util.TreeSet;

//整数反转
public class ReverseInt {
    public static int reverse(int x) {
        int check = x;
        int result = 0;
        while (check != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            //反转。
            int i = check % 10;
            result = result * 10 + i;
            check = check / 10;
        }
        return result;
    }
}
