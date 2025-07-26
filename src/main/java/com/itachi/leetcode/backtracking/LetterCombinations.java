package com.itachi.leetcode.backtracking;

import java.util.*;


public class LetterCombinations {

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int n = digits.length();
        if (n == 0){
            return result;
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
        result = map.get(digits.charAt(0));
        if (n == 1){
            return result;
        }
        int i = 1;
        while (i < n){
            List<String> temp = new ArrayList<>();
            for (String s1 : result) {
                for (String s2 : map.get(digits.charAt(i))) {
                    temp.add(s1+s2);
                }
            }
            result = temp;
            i++;
        }
        return result;
    }

    /**
     * 分析：
     *  当用户输入：23时。那么我们需要两个for循环，第一个循环遍历2对应的abc，第二个循环遍历3对应的def，两两组合成为一个结果
     *  当用户输入：234时。那么我们需要三个for循环，第一个循环遍历2对应的abc，第二个循环遍历3对应的def，第三个循环遍历4对应的ghi，三三组合成为一个结果。
     *  可以发现需要的for循环是我们无法控制的，for循环的次数受用户输入控制，因此这就需要回溯，利用回溯+递归隐藏循环
     *
     * @param combinations 用于存储每次凭借的结果
     * @param phoneMap 数字与字母之间的对应关系
     * @param digits 用户的输入
     * @param index  遍历用户输入的指针。比如用户输入：23,那么index的值为0,1,2。
     * @param combination stringBuffer，用于拼接
     */

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) { //比如上一层递归的是a，那么combination = “a"
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination); //得到么combination = “ad"
                //回溯的关键，需要删除d，这样那么combination还是为a，这样遍历到e的时候，可以组合成”ae"
                combination.deleteCharAt(index);
            }
        }
    }
}
