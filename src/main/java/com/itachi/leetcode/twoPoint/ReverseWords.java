package com.itachi.leetcode.twoPoint;

//151.反转字符串中的单词
public class ReverseWords {

    public static void main(String[] args) {
        String s = "a good   example";

        removeSpace(s);
    }

    /**
     * 去除掉前后，以及中间的多余空格
     *  将整个字符全部反转
     *  然后再将单个单词进行反转
     */
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }


    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }


    /**
     * 多余空格是指：一个单词与另一个单词之间可能存在多个空格，我们只能保留一个
     * 判断方式就是：如果当前是空格，并且下一位也是空格，那么就丢弃该字符
     */
    private static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (s.charAt(start) == ' ') {
            start++;
        }

        while (s.charAt(end) == ' ') {
            end--;
        }

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
}
