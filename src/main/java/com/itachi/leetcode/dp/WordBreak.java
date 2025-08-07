package com.itachi.leetcode.dp;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        int size = wordDict.size();
        //dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[wordDict.size() + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }
        for (int j = 0; j <= length; j++) {
            for (String i : wordDict) {
                int len = i.length();
                //字符串长度大于了选取的单词长度
                //并且不采用该单词的时候，之前的匹配能成功
                //并且采用该单词的时候，此次匹配也能成功
                if (j >= len && dp[j - len] && i.equals(s.substring(j - len, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }
}
