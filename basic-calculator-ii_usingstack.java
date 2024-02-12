class Solution {
    //TC: O(2n)
    //SC: O(n)
    public int calculate(String s) {
        s = s.trim();
        int curr = 0; 
        char lastEx = '+';
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((Character.isDigit(c))){
                curr = curr*10 + c - '0';
            }
            if((!(Character.isDigit(c)) && c != ' ')  || i == s.length() - 1){
                if(lastEx == '+'){
                    st.push(curr);
                }else if(lastEx == '-'){
                    st.push(-curr);
                }else if(lastEx == '*'){
                    st.push(st.pop()*curr);
                }else{
                    st.push(st.pop()/curr);
                }
                curr = 0;
                lastEx = c;
            }
        }
        int calc = 0;
        while(!st.isEmpty()){
            calc += st.pop();
        }
        return calc;
    }
}
