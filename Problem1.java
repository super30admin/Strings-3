//Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we use tail to store previous curr value, in case we hit * or /, we need to
//remove it from calculated value, multiply or divied and then add/subtract to the
//result, we maintain operations to perform on curr in lastEpres

// class Solution {
//     public int calculate(String s) {
//         s=s.trim();
//         int tail=0;
//         int calc=0;
//         int cur=0;
//         char lastExpre = '+';
//         for(int i=0;i<s.length();i++){
//             char c= s.charAt(i);
//             if(Character.isDigit(c)){
//                 cur=cur*10+c-'0';
//             }
//             if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
//                 if(lastExpre=='+'){
//                     calc=cur+calc;
//                     tail=cur;
//                 }
//                 else if(lastExpre=='-'){
//                     calc=calc-cur;
//                     tail=-cur;
//                 }
//                 else if(lastExpre=='*'){
//                     calc=calc-tail+tail*cur;
//                     tail=tail*cur;
//                 }
//                 else{
//                     calc=calc-tail+tail/cur;
//                     tail=tail/cur;
//                 }
//                 cur=0;
//                 lastExpre=c;
//             }
//         }
//         return calc;
//     }
// }


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we use stack to store values to be added/subtracted depending upon last expression,
//until we hit a * or / where we pop from the stack, last added curr, perform operation and
//put it with the sign.
import java.util.*;

class Problem1 {
    public int calculate(String s) {
        s=s.trim();
        int calc=0;
        int cur=0;
        Stack<Integer> st = new Stack<>();
        char lastExpre = '+';
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                cur=cur*10+c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastExpre=='+'){
                    st.push(cur);
                }
                else if(lastExpre=='-'){
                    st.push(-cur);
                }
                else if(lastExpre=='*'){
                    st.push(st.pop()*cur);
                }
                else{
                    st.push(st.pop()/cur);
                }
                cur=0;
                lastExpre=c;
            }
        }
        while(!st.isEmpty()){
            calc+=st.pop();
        }
        return calc;
    }
}