// tc : O(n) n=length of the input string
// sc : O(n)

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int curr=0;
        st.push(0);
        char op = '+';
        for( char c : s.toCharArray()){
            if(Character.isDigit(c)) curr=curr*10+c-'0';
            else if (c != ' '){
                
                if(op=='+') st.push(curr);
                else if(op == '-') st.push(-curr);
                else if(op == '*') st.push(st.pop()*curr);
                else st.push(st.pop()/curr);
                op=c;
                curr=0;
            }
        }
        if(op=='+') st.push(curr);
        else if(op == '-') st.push(-curr);
        else if(op == '*') st.push(st.pop()*curr);
        else st.push(st.pop()/curr);
        curr=0;
        while(!st.isEmpty()) curr+=st.pop();
        return curr;
}
}

