//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.Stack;

public class BasicCalculatorII {
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        char lastSign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length() - 1){
                if(lastSign == '+') st.push(num);
                if(lastSign == '-') st.push(-num);
                if(lastSign == '*') st.push(st.pop()*num);
                if(lastSign == '/') st.push(st.pop()/num);
                lastSign = c; num = 0;
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}
