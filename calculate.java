//TC - O(n);
//SC - O(k); k is number of digits;
//LC -227

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum=0;
        char op = '+';
        
        for(int i=0;i<s.length();i++){
            char currChar = s.charAt(i);
            
            if(Character.isDigit(currChar)){
                currNum = currNum*10 + (currChar-'0');
            }
            
            if((!Character.isDigit(currChar) && !Character.isWhitespace(currChar)) || i == s.length()-1){
                if(op=='+'){
                    st.push(currNum);
                }
                else if(op == '-'){
                    st.push(-currNum);
                }
                else if(op == '*'){
                    st.push(st.pop()*currNum);
                }
                else if(op == '/'){
                    st.push(st.pop()/currNum);
                }
                
                op = currChar;
                currNum = 0;
            }
        }
        
        int res=0;
        while(!st.isEmpty()){
            res=res+st.pop();
        }
        
        return res;
    }
}