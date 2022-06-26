// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if( s== null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char lastSign = '+';
        for(int i= 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr * 10 + ch - '0';
            }
            if((!Character.isDigit(ch) && ch != ' ') ||  i == s.length() -1){
                if(lastSign == '+')
                    stack.push(curr);
                else if(lastSign == '-')
                    stack.push(-curr);
                else if(lastSign == '*'){
                    stack.push(stack.pop() * curr);
                }
                else if(lastSign == '/'){
                    stack.push(stack.pop() / curr);
                }
                curr = 0;
                lastSign = ch;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
