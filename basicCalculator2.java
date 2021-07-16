//Time: O(n) where n is the length of s
//Space: O(k) where k are the number of digits in given string

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        
        Stack<Integer> st = new Stack<>();
        int result = 0;
        char lastSign = '+'; int num = 0;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c-'0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)){
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(num * st.pop());
                else st.push(st.pop()/num);
                lastSign = c;
                num = 0;
            }
        }
        while(!st.isEmpty()){
            result += st.pop();
        }
        
        return result;
    }
}