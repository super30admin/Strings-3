// Time complexity - O(n), n is length of string
// Space complexity - O(n)

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return  0;
        Stack<Integer> st = new Stack<>();
        char lastSign = '+';
        int num = 0;
        int n = s.length();
        for(int i= 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num* 10 + (c - '0');
            }
            if((!Character.isDigit(c)) && (c != ' ') || i == (n-1)){
                if(lastSign == '+'){
                    st.push(num);
                }else if(lastSign == '-'){
                    st.push(-num);
                }else if(lastSign == '*'){
                    st.push(st.pop() * num);
                }else if(lastSign == '/'){
                    st.push(st.pop() / num);
                }
                num = 0;
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
