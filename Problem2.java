//Time = O(n)
//Space = O(n)

class Solution {
    public int calculate(String s) {
        // Remove all spaces from the string
        s = s.replaceAll(" ", "");
        // Initialize the result, current number and operator, and a stack to store intermediate results
        int result = 0;
        int num = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();
        // Traverse through the string and perform operations based on the current operator
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is a digit, update the current number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // If the current character is not a digit or we have reached the end of the string, perform the operation
            if (!Character.isDigit(c) || i == s.length() - 1) {
                // Perform the operation based on the current operator and update the stack accordingly
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }
                // Update the operator and reset the current number
                operator = c;
                num = 0;
            }
        }
        // Add up all the elements in the stack to get the final result
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
