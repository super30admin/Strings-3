// Time Complexity - O(n) n = length of string
// Space Complexity - O(h) h = stack height

// Push the operands into the stack whenever you see an opeartor. The previous number
// is pushed into the stack and the last sign is always updated according to the sign of the previous number. 
// To maintain the precedence of using BODMAS, as you encounter the sign(* or /), pop from the stack and apply the corresponding operation and push the result as
// they need to be completed first on priority operators. 
// The last operand is always pushed into the stack. At the end add all the stack elements.

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        char lastSign = '+';
        int num = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = 10*num+(ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1) {
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(st.pop() * num);
                else if(lastSign == '/') st.push(st.pop()/num);
                num = 0;
                lastSign = ch;
            }
        }
        int res = 0;
        while(!st.isEmpty()) {
            res+=st.pop();
        }
        return res;
    }
}