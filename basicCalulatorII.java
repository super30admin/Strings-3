// Time Complexity : O(n), n is the length of s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * We iterate through each character in the string.
 * if the character is digit, we update the curr variable.
 * if an operator is found, we calculate the calc and tail values.
 * update the lastsign to the recent char and reset the curr to 0 for the next char. 
 * return the calc value at the end.
*/
class Solution {
    public int calculate(String s) {
        int calc = 0, tail = 0, curr = 0;
        char lastSign = '+';
        if (s == null)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((c != ' ' && !Character.isDigit(c)) || i == s.length() - 1) {
                if (lastSign == '+') {
                    calc += curr;
                    tail = curr;
                } else if (lastSign == '-') {
                    calc -= curr;
                    tail = -curr;
                } else if (lastSign == '*') {
                    calc = (calc - tail) + (tail * curr);
                    tail = tail * curr;
                } else {
                    calc = (calc - tail) + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = c;
            }
        }
        return calc;
    }
}

// stack

// Time Complexity : O(n), n is the length of s
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * We iterate through each character in the string.
 * if the character is digit, we update the curr variable.
 * if an operator is found, we calculate the curr according to operator and push
 * it in the stack.
 * update the lastsign to the recent char and reset the curr to 0 for the next
 * char.
 * After the loop, calculate the calc value, remove all the values from the
 * stack and add them.
 * return the calc value at the end.
 */
class Solution {
    public int calculate(String s) {
        int curr = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }

            if ((c != ' ' && !Character.isDigit(c)) || i == s.length() - 1) {
                if (lastSign == '+') {
                    st.push(curr);
                } else if (lastSign == '-') {
                    st.push(-curr);
                } else if (lastSign == '*') {
                    st.push(curr * st.pop());
                } else if (lastSign == '/') {
                    st.push(st.pop() / curr);
                }
                lastSign = c;
                curr = 0;
            }
        }

        int calc = 0;
        while (!st.isEmpty()) {
            calc += st.pop();
        }

        return calc;
    }
}