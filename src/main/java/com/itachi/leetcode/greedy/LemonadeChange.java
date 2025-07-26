package com.itachi.leetcode.greedy;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int fiveNum = 0;
        int tenNum = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNum++;
            } else if (bills[i] == 10) {
                fiveNum--;
                tenNum++;
            } else if (bills[i] == 20) {
                if (tenNum > 0) {
                    tenNum--;
                    fiveNum--;
                } else {
                    fiveNum -= 3;
                }
            }
            if (fiveNum < 0 || tenNum < 0) return false;

        }
        return true;
    }
}
