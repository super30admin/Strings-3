// Time: O(n)
// Space: O(n)
// Traversing through each character, when the operator is + and - we just store the current's(positive or negative value in stack.
// in case of * and division top is popped and calcualted value is pushed to stack
// finally we just have to add all the elements in stack.
class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        s = s.trim();
        int curr = 0; 
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr*10 + (c-'0');
            } 
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1) {
                if(lastSign=='+') {
                    st.push(curr);
                } else if(lastSign=='-') {
                    st.push(-curr);
                } else if(lastSign=='*') {
                    st.push(st.pop()*curr);
                } else if(lastSign=='/') {
                    st.push(st.pop()/curr);
                }
            lastSign=c;
            curr = 0;
            }
        }
        int calc = 0;
        while(!st.isEmpty()){
            calc += st.pop();
        }
        return calc;
    }
}