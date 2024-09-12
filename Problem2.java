// Problem2 : Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)
// Time - O(n)
// Space - O(n) - stack memory
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char prevsign = '+';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ' ) || i == s.length() - 1){
                switch(prevsign)
                {
                     case '+' : stack.push(num);
                                 break;
                     case '-' : stack.push(-num);
                
                                 break;
                
                     case '*' : stack.push(stack.pop() * num);
                
                                 break;
                     case '/' : stack.push(stack.pop() / num);
                
                           break;
                }
                prevsign = c;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        
        return res;
    }
 }