//TC: O(n)
//SC: O(n)
class Solution {
    public int calculate(String s) {
        int n = s.length();
        if(n == 0) return 0;
        Stack<Integer> st = new Stack();
        int num = 0; char lastSign = '+';
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num  = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == n-1){
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(st.pop() * num);
                else if(lastSign == '/') st.push(st.pop() / num);
                lastSign = c; num = 0;
            }
        }
        
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
