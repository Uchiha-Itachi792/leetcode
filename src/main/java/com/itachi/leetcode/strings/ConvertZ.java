package com.itachi.leetcode.strings;

/**
 * Z字型；即先从上向下，然后再右上回到第一行，再次从上向下
 * 将第一行看作是起点，那么：若规定的行数是r ,那么当我们在矩阵上填写字符时，会向下填写 r 个字符，然后向右上继续填写 r−2 个字符，最后回到第一行(起点)开启新的一轮。
 * 因此一轮用到的字符数为：sum = r + r-2 = 2r -2，假设总的字符串长度为n，那么一共需要 n/sum 轮(需要向上取整)
 * 每个周期会占用矩阵上的 sumCol = 1 +r−2 = r−1 列，因此总的列数为 (n/sum) * sumCol
 */
public class ConvertZ {

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);


    }

    public static String convert(String s, int numRows) {
        int n = s.length();
        int r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        //每轮用到的字符数
        int t = r * 2 - 2;
        //分析的公式为：(n / t)  * (r - 1)，此处(n+t-1)/t是为了向上取整。
        //比如3行，二维数组对应的是0，1，2，因此需要r -1=2
        int c = (n + t - 1) / t * (r - 1);
        //创建二维数组
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            //有r行，而二维数组是从0开始，因此需要r -1
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
