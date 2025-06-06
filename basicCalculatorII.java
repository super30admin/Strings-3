// Time Complexity :O(n);
//Space Complexity :O(1);
class Solution {
    public int calculate(String s) {
        int curr = 0, lastNum = 0, result = 0;
        char op = '+';
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (op == '+') {
                    result += lastNum;
                    lastNum = curr;
                } else if (op == '-') {
                    result += lastNum;
                    lastNum = -curr;
                } else if (op == '*') {
                    lastNum = lastNum * curr;
                } else if (op == '/') {
                    lastNum = lastNum / curr;
                }
                op = c;
                curr = 0;
            }
        }

        result += lastNum;
        return result;
    }
}
