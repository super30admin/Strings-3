//time : O(n)
//space : O(n)

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char lastsign = '+';
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastsign == '+') {
                    st.push(currNum);
                } else if (lastsign == '-') {
                    st.push(-currNum);
                } else if (lastsign == '*') {
                    st.push(st.pop() * currNum);
                } else if (lastsign == '/')
                    st.push(st.pop() / currNum);
                currNum = 0;
                lastsign = c;
            }
        }
        int result = 0;
        while (!st.isEmpty()) {
            result = result + st.pop();
        }
        return result;
    }
}

// time : O(n)
// Space : O(1)

class Solution {
    public int calculate(String s) {
        // Stack<Integer> st = new Stack<>();
        char lastsign = '+';
        int result = 0;
        int currNum = 0;
        int tail = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastsign == '+') {
                    result = result + currNum;
                    tail = currNum;
                } else if (lastsign == '-') {
                    result = result - currNum;
                    tail = -currNum;
                } else if (lastsign == '*') {
                    result = result - tail + tail * currNum;
                    tail = tail * currNum;
                } else if (lastsign == '/') {
                    result = result - tail + tail / currNum;
                    tail = tail / currNum;
                }
                currNum = 0;
                lastsign = c;
            }
        }

        return result;
    }
}
