//time complexity O(n)
//space complexity O(n)
class Solution {
    Stack<Integer> st;
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        char lastSign = '+';
        int num = 0;
        st = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            //is not a digit and not a space or is the last element
            if((!Character.isDigit(c) && c != ' ') || i == n - 1){
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(st.pop() * num);
                else if(lastSign == '/') st.push(st.pop() / num);                
                num = 0; lastSign = c;
            }
        }
        int result  = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
    return result;
    }
}
