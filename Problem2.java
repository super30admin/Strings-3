/*
    LC - 227. Basic Calculator II
    TC - O(n)
    SC - O(n)
    Approach -
        Using stack and char lastSign
        check if char is digit and char sign
        make the calculation using the derived formula
        return the calculated value
*/

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int curr = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if(!Character.isDigit(c) && c!= ' ' || i == s.length() - 1) { // check c should not digit & not spaces (which means its an operator) or it should be the last element.
                if(lastSign == '+') {
                    st.push(+curr);
                }
                if(lastSign == '-') {
                    st.push(-curr);
                }
                if(lastSign == '*') {
                    st.push(st.pop() * curr);
                }
                if(lastSign == '/') {
                    st.push(st.pop() / curr);
                }
                lastSign = c;
                curr = 0;
            }
        }
        int calc = 0;
        while(!st.isEmpty()) {
            calc = calc + st.pop();
        }
        return calc;
    }
}


/*
    LC - 227. Basic Calculator II
    TC - O(n)
    SC - O(1)
    Approach -
        Using char lastSign
        check if char is digit and char sign
        make the calculation using the derived formula
        return the calculated value
*/


class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int curr = 0;
        char lastSign = '+';
        int calc = 0, tail = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if(!Character.isDigit(c) && c!= ' ' || i == s.length() - 1) {
                if(lastSign == '+') {
                    calc = calc + curr;
                    tail = +curr;
                }
                if(lastSign == '-') {
                    calc = calc - curr;
                    tail = -curr;
                }
                if(lastSign == '*') {
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }
                if(lastSign == '/') {
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }
                lastSign = c;
                curr = 0;
            }
        }
        return calc;
    }
}