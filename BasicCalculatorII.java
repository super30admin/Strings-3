import java.util.Stack;
// Time Complexity:O(n)
// Space Complexity:O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class BasicCalculatorII {
    class Solution {
        public int calculate(String s) {
            if(s.length()==0||s==null) return 0;

            Stack<Integer> st = new Stack<>();

            int curr =0;
            char operation = '+';
            char[] ch = s.toCharArray(); //convert string to char array

            //loop over character arrary and take in to account when char is digit or not
            for (int i = 0; i < ch.length; i++) {
                //when it is a digit case
                if(Character.isDigit(ch[i])){
                    curr = curr*10+ch[i] - '0';
                }

                //when it is not digit case
                if(!Character.isDigit(ch[i]) && ch[i] != ' ' || i == ch.length-1){
                    if(operation == '+'){
                        st.push(curr);
                    }else if(operation == '-'){
                        st.push(-curr);
                    }else if(operation == '*'){
                        st.push(st.pop() * curr);
                    }else if(operation == '/'){
                        st.push(st.pop() / curr);
                    }
                    operation = ch[i];//update operation
                    curr = 0;
                }
            }
            int sum=0;
            while(!st.isEmpty()) {
                sum += st.pop();
            }
            return sum;
        }
    }
}
