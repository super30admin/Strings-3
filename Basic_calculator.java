class Solution {
    public int calculate(String s) {
        
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        Stack<Integer> st = new Stack<>();
        char lastSign = '+';
        int num = 0;
        
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            
            if(c != ' ' && (!Character.isDigit(c) || i == s.length()-1)){
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(st.pop() * num);
                else st.push(st.pop()/num);
                lastSign = c;
                num = 0;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        
        return result;
        
    }
}

//TC: O(N)
//SC: O(N)
