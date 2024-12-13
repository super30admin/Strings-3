/*
 * TC - O(n)
 * sc - O(n)
 */

import java.util.Stack;

public class BasicCalculator{
     //   stack based approach 
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + (c - '0');
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length()-1){
                if(lastSign == '+'){
                    st.push(currNum);
                }else if(lastSign == '-'){
                    st.push(-currNum);
                }else if(lastSign == '*'){
                    int popped = st.pop();
                    st.push(popped * currNum);
                }else if(lastSign == '/'){
                    int popped = st.pop();
                    st.push(popped / currNum);
                }
                currNum = 0;
                lastSign = c;
            }
        }
        int result = 0; 
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }

    // public int calculate(String s){
    //     int currNum = 0;
    //     char lastSign = '+';
    //     int calc = 0, tail = 0;
    //     for(int i = 0; i < s.length();i++){
    //         char c = s.charAt(i);
    //         if(Character.isDigit(c)){
    //             currNum = currNum * 10 + (c - '0');
    //         }
    //         if(!Character.isDigit(c) && c != ' ' || i == s.length()-1){
    //             if(lastSign == '+'){
    //                 calc = calc + currNum;
    //                 tail = currNum;
    //             }else if(lastSign == '-'){
    //                 calc = calc - currNum;
    //                 tail = currNum;
    //             }else if(lastSign == '*'){
    //                 calc = (calc + tail ) - (tail * currNum);
    //                 tail = tail * currNum;
    //             }else if(lastSign == '/'){
    //                 calc = (calc + tail) - (tail / currNum);
    //                 tail = tail/currNum;
    //             }
    //             currNum = 0;
    //             lastSign = c;
    //         }
    //     }
    //     return calc;

    // }
}