//Time Complexity: O(n)
//Space Complexity: O(1) 

/*
 * In this approach we go through each char of the string. If it is a number we update the curr. If it an operator we calc the value based on the operator. 
 * And we upadte the calc and tail values. Then we update the lastsign to the recent char and reset the curr to 0 for the next char. 
 * Finally we return the calc value at the end.
*/
class Solution {
    public int calculate(String s) {
        if(s == null)return 0;
        char lastSign = '+';
        int curr = 0;
        int calc = 0;
        int tail =0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10+ c - '0';
            }
            if((!Character.isDigit(c) && c != ' ' )|| i == s.length()-1){
                if(lastSign == '+'){
                    calc = curr+calc;
                    tail=curr;
                }else if(lastSign == '-'){
                    calc = calc-curr;
                    tail=-curr;
                }else if(lastSign == '*'){
                    calc = calc-tail + tail*curr;
                    tail=tail*curr;
                }else if(lastSign == '/'){
                    calc = calc-tail + tail/curr;
                    tail=tail/curr;
                } 
                lastSign = c;
                curr =0;
            }

        }
        return calc;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n) 

/*
 * In this approach we use a stack to store the characters. If it is a digit we update the curr. If it + or -, we push the curr vvalue with the sign in the stack.
 * If it is * or / we pop the stack value and *or / with curr and push it back. We then update the lastsign to nect char and reset the curr to 0. Once
 * the whole string is processed we empty the stack and add all the values. 
*/
class Solution {
    public int calculate(String s) {
        if(s == null)return 0;
        char lastSign = '+';
        int curr = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10+ c - '0';
            }
            if((!Character.isDigit(c) && c != ' ' )|| i == s.length()-1){
                if(lastSign == '+'){
                    st.push(curr);
                }else if(lastSign == '-'){
                    st.push(-curr);
                }else if(lastSign == '*'){
                    // curr = curr * st.pop();
                    st.push(curr * st.pop());
                }else if(lastSign == '/'){
                    // curr = curr / st.pop();
                    st.push(st.pop()/curr);
                } 
                lastSign = c;
                curr =0;
            }

        }
        int result =0 ;
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}