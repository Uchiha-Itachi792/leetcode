package com.itachi.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

//202. 快乐数

public class IsHappyNumber {

    public static void main(String[] args) {
        IsHappyNumber isHappyNumber = new IsHappyNumber();
        isHappyNumber.isHappy(2);
    }
    /**
     * 若不是快乐数，那么一定有某个sum周期性出现，可以用一个hashset来进行判断
     *  将每次计算得到的sum存储到hashset中，对于新计算的sum，需要用hashset来判断，若包含就不是快乐数
     */
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            //计算新的sum
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10; //获取最后一位数
            res += temp * temp;
            n = n / 10; //去掉最后一位数
        }
        return res;
    }
}
