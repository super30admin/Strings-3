/* Time Complexity : O(2n) ~ O(n)
 *  n - length of the string */
/* Space Complexity : O(n)
*  size of the stack */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int currNum = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + ch - '0';
            }
            if(i == s.length()-1 || (!Character.isDigit(ch) && ch != ' ')){
                if(lastSign == '+'){
                    st.push(currNum);
                } else if(lastSign == '-'){
                    st.push(-currNum);
                } else if(lastSign == '*'){
                    int popped = st.pop();
                    st.push(popped*currNum);
                } else{
                    int popped = st.pop();
                    st.push(popped/currNum);
                }
                currNum = 0;
                lastSign = ch;
            }
        }

        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}