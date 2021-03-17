// Time and space: O(n)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        //maintain stack to postpone the operation until we encounter * or /
        Stack<Integer> st = new Stack<>();
        s = s.trim();
        //intially -
        int num = 0;
        char lastsign = '+';
        int result = 0;
        
        //iterate over string
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
                num = num * 10 + (curr - '0');
            }
            
            if(curr == ' ') continue;
            //is not digit
            if(!Character.isDigit(curr) || i == s.length()-1 ){
                //if last sign is +/-, push to the stack
                
                if(lastsign == '+') st.push(num);
                else if(lastsign == '-') st.push(-num);
                
                //if last sign is * or /, process so far in stack n push back
                else if(lastsign == '*'){
                    int mul = st.pop() * num;
                    st.push(mul);
                }
                else if(lastsign == '/'){
                    int div = st.pop() / num;
                    st.push(div);
                }
                
                lastsign = curr;
                num = 0;
            }
        }
        //now the stack will have just + or - result, just add them
        while(!st.isEmpty()){
            result += st.pop();
        }
        
        return result;
    }
}