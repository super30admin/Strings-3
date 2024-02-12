// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int calculate(String s) {
        s = s.trim();
        char lastSign;
        int currNum = 0;
        Stack<Integer> stk = new Stack<>();
        lastSign = '+';
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum*10 + (ch - '0');
            }
            if((ch!=' ' && !Character.isDigit(ch)) || i == s.length()-1){
                if(lastSign == '+'){
                    stk.push(currNum);
                }
                else if(lastSign == '-'){
                    stk.push(-currNum);
                }
                else if(lastSign == '*'){
                    int popped = stk.pop();
                    stk.push(currNum*popped);
                }
                else if(lastSign == '/'){
                    int popped = stk.pop();
                    stk.push(popped/currNum);
                }
                currNum = 0;
                lastSign = ch;
            }
        }
        int res = 0;
        while(!stk.isEmpty()){
            int popped = stk.pop();
            res += popped;
        }
        return res;
    }
}