// Time Complexity: O(n) where n is length of string
// Space Complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BasicCalc2 {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();        // Not required since we will be checking this later.
        char lastsign = '+';
        int calc = 0, curr = 0, tail = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');   // Diff of ASCII values
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {    // Last character won't compute if this is an elseif statement.
                if(lastsign == '+') {
                    calc = calc + curr;
                    tail = +curr;
                }
                else if(lastsign == '-') {
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastsign == '*') {
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                }
                else if(lastsign == '/') {
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                lastsign = c;
                curr = 0;
            }
        }
        return calc;
    }
    
    // Implementing using a stack.
    // TC: O(n).
    // SC: O(n).
    // public int calculate(String s) {
    //     if(s == null || s.length() == 0) return 0;
    //     Stack<Integer> st = new Stack<>();
    //     s = s.trim();        // Not required since we will be checking this later.
    //     char lastsign = '+';
    //     int calc = 0, curr = 0;
    //     for(int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if(Character.isDigit(c)) {
    //             curr = curr * 10 + (c - '0');   // Diff of ASCII values
    //         }
    //         if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {    // Last character won't compute if this is an elseif statement.
    //             if(lastsign == '+') {
    //                 st.push(curr);
    //             }
    //             else if(lastsign == '-') {
    //                 st.push(-curr);
    //             }
    //             else if(lastsign == '*') {
    //                 st.push(st.pop() * curr);
    //             }
    //             else if(lastsign == '/') {
    //                 st.push(st.pop() / curr);
    //             }
    //             lastsign = c;
    //             curr = 0;
    //         }
    //     }
    //     while(!st.isEmpty()) {
    //         calc = calc + st.pop();
    //     }
    //     return calc;
    // }
}