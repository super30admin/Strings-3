// Using stack Solution
// Time complexity - O(n)
// Space complexity - O(n)
// Solved on leetcode - yes
// Faced any issues - No
// This solution uses a single pass through the string while maintaining a stack to evaluate the expression. It builds numbers digit by digit, and based on the last seen operator (+, -, *, /), it either pushes the number to the stack or combines it with the top of the stack for multiplication or division. After processing the entire string, it sums up all values in the stack to get the final result.

// Without stack
// Time complexity - O(n)
// Space complexity - O(1)
// Solved on leetcode - yes
// Faced any issues - No 
// Every time we get a signw e are calculating the value and updating the tail and current
class Solution {
    public int calculate(String s) {
        // Stack<Integer> stack = new Stack<>();
        // int current =0;
        // char sign = '+';
        // int tail =0;
        // for(int i=0;i<s.length();i++) {
        //     char c = s.charAt(i);
        //     if(Character.isDigit(c)) {
        //         current = current *10 + (c-'0');
        //     } 
            
        //    if((!Character.isDigit(c)  && c != ' ') || i == s.length()-1){
        //        if( sign == '+' ){
        //            stack.push(+current);
        //        }
        //        else if( sign == '-'){
        //            stack.push(-current);
        //        } else if(sign == '*') {
        //             stack.push(stack.pop() * current);
        //        } else if(sign == '/') {
        //             stack.push(stack.pop() / current);
        //        }
        //        current =0;
        //        sign = c;
        //    }
        // }
        // int result =0;
        // while(!stack.isEmpty()) {
        //     result = result + stack.pop();
        // }
        // return result;

        int tail =0, cal =0,current =0;
        char sign = '+';
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                current = current *10 + (c-'0');
            } 
            if((!Character.isDigit(c) && c != ' ') || i==s.length()-1) {
                if(sign == '+') {
                    cal = cal + current;
                    tail = current;
                } else if(sign == '-') {
                    cal = cal - current;
                    tail = -current;
                } else if(sign == '*') {
                    cal = cal-tail+tail*current;
                    tail = tail*current;
                } else if(sign == '/') {
                    cal = cal-tail + tail/current;
                    tail = tail/current;
                }
                current =0;
                sign = c;
            }
        }
        return cal;
    }
}
