/*
 Time Complexity = O(n) where n is length of given string
 Space Complexity = O(1) -> for using tail solution and O(n) for using stack solution
 Did it run on LeetCode: yes

 */

package com.madhurima;

import java.util.Stack;

public class BasicCalculator2 {

    //without using extra space
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        s = s.trim();

        int calc = 0;
        int tail = 0;
        int num = 0;
        char lastSign = '+';

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
            }

            if((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)){
                if(lastSign == '+'){
                    calc = calc + num;
                    tail = +num;
                }
                if(lastSign == '-'){
                    calc = calc - num;
                    tail = -num;
                }
                if(lastSign == '*'){
                    calc = calc - tail + (tail*num);
                    tail = tail * num;
                }
                if(lastSign == '/'){
                    calc = calc - tail + (tail/num);
                    tail = tail/num;
                }
                lastSign = c;
                num = 0;
            }

        }
        return calc;
    }


    //using stack
    public int calculateStack(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        s = s.trim();

        Stack<Integer> st = new Stack<>();

        int calc = 0;
        int num = 0;
        char lastSign = '+';

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
            }

            if((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)){
                if(lastSign == '+'){
                    st.push(num);
                }
                if(lastSign == '-'){
                    st.push(-num);
                }
                if(lastSign == '*'){
                    st.push(st.pop() * num);
                }
                if(lastSign == '/'){
                    st.push(st.pop() / num);
                }
                lastSign = c;
                num = 0;
            }
        }

        while(!st.isEmpty()){
            calc = calc + st.pop();
        }

        return calc;
    }
}
