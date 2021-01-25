/** Given a string s which represents an expression, evaluate this expression and return its value. 
* TC O(N) SC O(N) - Stack to store  
*/
class Solution {
    public int calculate(String s) {
        int result = 0;
        if (s == null || s.length() == 0)
            return result;
        int num = 0;
        char lastSign = '+';
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num *10 + c - '0';             
            }
            if ((!Character.isDigit(c) && c != ' ') || (i == s.length()-1)) {
                if (lastSign == '-') {
                    stk.push(-num);
                }
                else if (lastSign == '*'){
                    stk.push(stk.pop() * num);
                }
                else if (lastSign == '/') {
                     stk.push(stk.pop() / num);
                }
                else if (lastSign == '+') {
                    stk.push(num);
                }
                lastSign = c;
                num = 0;
            }
            
        }
        while(!stk.empty()){
                result = result + stk.pop();
            }
        return result;
    }
}
