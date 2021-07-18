
// Time - O(N)
// space - O(N)


class Solution {
    public int calculate(String s) {

        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        s = s.trim();
        int result = 0;
        char lastSign = '+';    // initialize last Sign to '+'
        int num = 0;        // initialize num to 0

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';   // multiply prev value by 10 and add with the ASCII val
            }

            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)) {

                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(st.pop() * num);
                else st.push(st.pop() / num);
                lastSign = c;
                num = 0;

            }

        }

        while(!st.isEmpty()) {
            result += st.pop();
        }

        return result;

    }
}