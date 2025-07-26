package com.itachi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 整个流程一共处于四种状态：start（开始），signed(记录符号)，number(记录数字)，end(结束)。
 * 而每种状态在遇到不同类型的字符的时候，会转变成不同的状态，流程最开始处于start状态：
 *  1. 若遇到空格，那么指针继续移动，start->start
 *  2. 若遇到 + 或者 - ，那么start->signed
 *  3. 若遇到数字，那么start->number
 *  4. 若遇到非数字，那么start->end
 *
 *  因此可以整理出以下对应关系：
 *
 *  	       空格	  +/-	    数字	        非数字
 * start	  start	  signed	number	     end
 * signed	  end	  end	    number	     end
 * number     end	  end	    number	     end
 * end	      end	  end	    end	         end
 *
 * 我们要做的就是，存储上述列表，遍历每个字符，利用字符与当前状态获取下一个状态。
 */



public class MyAtoi {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start"; //初始化流程的开始状态为start

    //存储状态对应表
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "number", "end"});
        put("signed", new String[]{"end", "end", "number", "end"});
        put("number", new String[]{"end", "end", "number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        //根据字符类型获取状态
        state = table.get(state)[get_col(c)];
        //如果是state=number，开始计数
        if ("number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) { //判断正负
            sign = c == '+' ? 1 : -1;
        }
    }
    //判断字符的类型
    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
