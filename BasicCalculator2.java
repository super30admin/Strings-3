// Time Complexity : O(n), n = length of string s
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create a variable to store the number parsed and the expression, if expression is + or - then store it to the stack, and if expression is * or /, perform the calculation using the top element from the stack and store it back to the stack. At the end take the sum of all elements in the stack.
 
public class BasicCalculator2 {
    public int calculate(String s) {
        
        int num = 0;
        char expression = '+';
        
        Stack<Integer> st = new Stack<>();
        int result = 0;
        for(int i = 0; i <= s.length(); i++){
            char curr = '0';
            if(i < s.length())
                curr = s.charAt(i);
            
            if(i < s.length() && Character.isDigit(curr)){
                num = num * 10 + Character.getNumericValue(curr);
            } else if(i == s.length() || curr != ' ' ){
                if(expression == '+'){
                    st.add(num);
                } else if(expression == '-'){
                    st.add(-num);
                } else if(expression == '*'){
                    st.add(st.pop() * num);
                } else if(expression == '/'){
                    st.add(st.pop() / num);
                }
                num = 0;
                expression = curr;
            }
            
            if(i == s.length()){
                while(!st.isEmpty())
                    result = result + st.pop();
            }
        }
        
        return result;
    }
}
