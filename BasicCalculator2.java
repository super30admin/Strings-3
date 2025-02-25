/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Iterate through the string character by character.
 * If the character is a digit, update num by shifting its previous value (to handle multi-digit numbers).
 * If the character is an operator or the last character in the string:
 * Process the previous number with respect to lastSign.
 * Update calc and tail accordingly.
 * Reset num and store the current operator in lastSign.
 * + : Add num to calc, update tail with num.
 * - : Subtract num from calc, update tail with -num.
 * * : Since * has higher precedence than + or -, correct the previous operation by subtracting tail from calc and
 *  replacing it with the new multiplication result.
 * / : Similar to *, adjust calc by replacing tail with its division result.
 */

public class BasicCalculator2 {
    public int calculate(String s) {
        if (s.length() == 1) {
            return s.charAt(0) - '0';
        }

        int calc = 0;
        int num = 0;
        int tail = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if ((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                if (lastSign == '+') {
                    calc = calc + num;
                    tail = +num;
                }

                if (lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                }

                if (lastSign == '*') {
                    calc = calc - tail + (tail * num);
                    tail = tail * num;
                }

                if (lastSign == '/') {
                    calc = calc - tail + (tail / num);
                    tail = tail /num;
                }

                num = 0;
                lastSign = c;
            }
        }
        return calc;
    }

    public static void main(String[] args) {
        // Your code here
        BasicCalculator2 obj = new BasicCalculator2();
        int num = obj.calculate("123*5*6/8-1234");
        System.out.println(num);
        assert (num == -773);
    }   
}