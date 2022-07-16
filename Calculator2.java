//TC - O(n)
//SC - O(1)
class Solution {
    public int calculate(String s) {
        char lastSign = '+';
        int currNum = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() -1){
                if(lastSign == '+') st.push(currNum);
                else if(lastSign == '-') st.push(-currNum);
                else if(lastSign == '*') st.push(st.pop()*currNum);
                else if(lastSign == '/') st.push(st.pop()/currNum);
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
