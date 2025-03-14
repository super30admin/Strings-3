// Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

// Time Complexity : O(n) n is length of string
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, while traversing along the string, for each character check if char is digit, it its digit, curr = curr*10+ch and if its not digit and
 * not space or its last digit and inside it, if ch is +, calc = calc + curr and tail = curr, else if ch is -, calc = calc - curr and tail = -curr,
 * else if ch is *, calc = calc - tail + tail * curr and tail = tail * curr, else if ch is /, calc = calc - tail + tail / curr and tail = tail / curr,
 * and make curr to 0 and lastsign as ch. Finally return calc.
 */
// class Solution {
//     public int calculate(String s) {
//         Stack<Integer> st = new Stack<>();
//         int curr = 0;
//         char lastSign = '+';
//         for(int i = 0; i<s.length();i++){
//             char ch = s.charAt(i);
//             if(Character.isDigit(ch)){
//                 curr = curr * 10 + ch - '0';
//             }
//             if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
//                 if(lastSign == '+'){
//                     st.push(curr);
//                 }
//                 else if(lastSign == '-'){
//                     st.push(-curr);
//                 }
//                 else if(lastSign == '*'){
//                     int temp = st.pop();
//                     st.push(temp*curr);
//                 }
//                 else if(lastSign == '/'){
//                     int temp = st.pop();
//                     st.push(temp/curr);
//                 }
//                 curr = 0;
//                 lastSign = ch;
//             }
//         }
//         int result = 0;
//         while(!st.isEmpty()){
//             result += st.pop();
//         }
//         return result;
//     }
// }

class Solution {
    public int calculate(String s) {
        int curr = 0;
        char lastSign = '+';
        int calc = 0;
        int tail = 0;
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign == '*'){
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }
                else if(lastSign == '/'){
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = ch;
            }
        }

        return calc;
    }
}