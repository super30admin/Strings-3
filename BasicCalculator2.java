class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int curr = 0; char lastSign = '+';
        s = s.trim();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                curr = curr*10 + s.charAt(i) - '0';
                if(i == s.length()-1){
                    if(lastSign == '*'){
                        st.push(st.pop()*curr);
                        curr = 0; lastSign = s.charAt(i);
                    }else if(lastSign == '/'){
                        st.push(st.pop()/curr);
                        curr = 0; lastSign = s.charAt(i);
                    }else if(lastSign == '+'){
                        st.push(curr);
                        curr = 0; lastSign = s.charAt(i);
                    }else if(lastSign == '-'){
                        st.push(-curr);
                        curr = 0; lastSign = s.charAt(i);
                    }
                }
            }else if(s.charAt(i)!=' ' && !Character.isDigit(s.charAt(i))){
                if(lastSign == '*'){
                    st.push(st.pop()*curr);
                    curr = 0; lastSign = s.charAt(i);
                }else if(lastSign == '/'){
                    st.push(st.pop()/curr);
                    curr = 0; lastSign = s.charAt(i);
                }else if(lastSign == '+'){
                    st.push(curr);
                    curr = 0; lastSign = s.charAt(i);
                }else if(lastSign == '-'){
                    st.push(-curr);
                    curr = 0; lastSign = s.charAt(i);
                }
            }
        }
        int res = 0;
        while(!st.isEmpty()){
            res = res + st.pop();
        }
        return res;
    }
}