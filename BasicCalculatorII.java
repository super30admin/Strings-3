class Solution {
    // TC: N + N ~= 2N ~= O(N)
    // SC: N for Stack
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char ZERO = '0';
    private static final char NINE = '9';
    private static final char SPACE = ' ';
    private static final HashSet<Character> SIGNS = new HashSet<>() {{
        add(ADDITION);
        add(SUBTRACTION);
        add(MULTIPLICATION);
        add(DIVISION);
    }};
    public int calculate(String s) {
        int number = 0;
        char lastSign = ADDITION; // default
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // remove spaces
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != SPACE) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        // Find numbers and signs and perform operations
        while (index < s.length()) {
            // find number
            while (index < s.length() && s.charAt(index) >= ZERO && s.charAt(index) <= NINE) {
                number *= 10;
                number += s.charAt(index) - ZERO;
                index ++;
            }
            // perform operations with previous sign
            if (lastSign == ADDITION) {
                stack.push(number);
            } else if (lastSign == SUBTRACTION) {
                stack.push(-1 * number);
            } else if (lastSign == MULTIPLICATION) {
                stack.push(stack.pop() * number);
            } else if (lastSign == DIVISION) {
                stack.push(stack.pop() / number);
            }
            if (index < s.length() && SIGNS.contains(s.charAt(index))) {
                lastSign = s.charAt(index); // update sign
                number = 0; // update number
            }
            index ++; // increment index
        }
        int result = 0;
        // sum all values in the stack
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}