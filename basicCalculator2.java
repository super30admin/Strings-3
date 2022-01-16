// Time Complexity = O(n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Using a stack: Whenever you encounter a sign push the curr onto the stack:
// for + push curr, for - push -curr, for * push stack.pop()*curr, for / push stack.pop()/curr
// at the end of each sign condition, change the value of lastSign and reset curr to 0
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int n=s.length();
        int curr = 0, calc=0;
        char lastSign='+';
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<n; i++) {
            char c=s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr*10 + c-'0';
            }
            if ((!Character.isDigit(c) && c != ' ') || (i == n-1)) {
                if (lastSign == '+') {
                    st.push(curr);
                }
                else if (lastSign == '-') {
                    st.push(-curr);
                }
                else if (lastSign == '*') {
                    st.push(st.pop() * curr);
                }
                else {
                    st.push(st.pop() / curr);
                }

                curr=0;
                lastSign = c;
            }
        }

        while (!st.isEmpty()) {
            curr += st.pop();
        }

        return curr;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// This is a space optimized solution over the stack one but less intutive and might be more difficult to come up with the formula in exam
// Without using a stack: Whenever you encounter a sign we update values for curr, tail, calc and lastSign
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int n=s.length();
        int curr = 0, calc=0, tail=0;
        char lastSign='+';

        for (int i=0; i<n; i++) {
            char c=s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr*10 + c-'0';
            }
            if ((!Character.isDigit(c) && c != ' ') || (i == n-1)) {
                if (lastSign == '+') {
                    calc = calc+curr;
                    tail = curr;
                }
                else if (lastSign == '-') {
                    calc = calc-curr;
                    tail = -curr;
                }
                else if (lastSign == '*') {
                    calc = (calc-tail) + (tail*curr);
                    tail = (tail*curr);
                }
                else {
                    calc = (calc-tail) + (tail/curr);
                    tail = (tail/curr);
                }

                curr=0;
                lastSign = c;
            }
        }

        return calc;
    }
}
