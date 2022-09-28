// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Calculate {
    public int calculate(String s) {
        char lastsign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastsign=='+') stack.push(num);
                else if(lastsign == '-') stack.push(-num);
                else if(lastsign == '/') stack.push(stack.pop()/num);
                else if(lastsign == '*') stack.push(stack.pop()*num);
                num = 0;
                lastsign = c;
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result+= stack.pop();
        }

        return result;
    }
}