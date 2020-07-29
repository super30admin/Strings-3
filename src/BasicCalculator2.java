// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/* multiply and divide cause problems, so when we get that, solve it and then push number to stack
 * maintain prev sign for that
 * at end, sum of stack elements
 * 
 * https://leetcode.com/problems/basic-calculator-ii/
 */

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        
        char prevSign = '+';
        int num = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
            	    // for case where number is like 456 instead of single digit number
                num = num * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1){
                if(prevSign == '+') st.push(num);
                else if (prevSign == '-') st.push(-num);
                else if(prevSign == '*') st.push(st.pop() * num);
                else st.push(st.pop() / num);
                //number is pushed, reset it
                num = 0; prevSign = c;
            } 
        }
        
        int res = 0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        
        return res;
    }
}