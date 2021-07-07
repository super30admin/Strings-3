package s30Coding;
import java.util.*;
//Time complexity :- O(n) where n is the length of the string
//Space Complexity :- O(n) where n is the length of the string
//LeetCode :- Yes

public class BasicCalculator {
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int lastSign = '+'; int num =0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10*num + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') ||(i == n -1)){
                if(lastSign == '+'){
                    st.push(num);
                }
                else if(lastSign == '-'){
                    st.push(-num);
                }
                else if(lastSign == '*'){
                    st.push(st.pop()*num);
                }
                else if(lastSign == '/'){
                    st.push(st.pop()/num);
                }
                num = 0; lastSign = c;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result +=st.pop();
        }
        return result;
    }
}
