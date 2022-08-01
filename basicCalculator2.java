// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

class Solution {
    public int calculate(String s) {
        char lastSign = '+';
        int currNum = 0;
        int calc = 0; int tail = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(lastSign == '+'){
                    calc = calc + currNum;
                    tail = currNum;
                } else if(lastSign == '-') {
                    calc = calc - currNum;
                    tail = -currNum;
                } else if(lastSign == '*'){
                    calc = calc - tail + tail * currNum;
                    tail = tail * currNum;
                } else if(lastSign == '/'){
                    calc = calc - tail + tail / currNum;
                    tail = tail / currNum;
                }
                currNum = 0;
                lastSign = c;
            }
        } 
        return calc;
    }
}

/*
// for this problem
class Solution {
    public int calculate(String s) {
        char lastSign = '+';
        int currNum = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(lastSign == '+') st.push(currNum);
                else if(lastSign == '-') st.push(-currNum);
                else if(lastSign == '*') st.push(st.pop() * currNum);
                else if(lastSign == '/') st.push(st.pop() / currNum);
                currNum = 0;
                lastSign = c;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
*/