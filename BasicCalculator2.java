// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can keep the last operation in char variable
// When we encounter digit we will form numbers
// when we see an operation + or - we will add last or -last to answer
// When we see * or / we will multiply or divide last and cur
// We will change the operation for the character oper
// At the end we will have our result in ans

class Solution {
    public int calculate(String s) {
        int l = s.length();
        if(s == null || s.isEmpty())
            return 0;
        int cur = 0, last = 0, res = 0;
        char oper = '+';
        for(int i = 0; i < l; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                cur = cur * 10 + c - '0';
            }
            if(!Character.isDigit(c) &&!Character.isWhitespace(c) || i == l-1){
                if(oper == '+' || oper == '-'){
                    res += last;
                    last = (oper == '+') ? cur : -cur;
                }
                else if(oper == '*'){
                    last = last * cur;
                }
                else if(oper == '/'){
                    last = last / cur;
                }
                    oper = c;
                    cur = 0;
            }
        }
        res += last;
        return res;
    }
}