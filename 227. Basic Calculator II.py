# Time complexity: O(n), where n is the length of the input string 's'.
# Space complexity: O(n), where n is the maximum number of digits in the input string 's'.

class Solution:
    def calculate(self, s: str) -> int:
        lastSign = '+'  # Initialize the last operator encountered to '+'.
        curr = 0        # Initialize a variable to store the current number being parsed.
        stack = []      # Initialize a stack to store intermediate results during parsing.
        s = s.strip()   # Remove leading and trailing whitespaces from the input string 's'.
        result = 0      # Initialize the result variable to store the final answer.

        for i in range(len(s)):  # Loop through each character in the input string 's'.
            c = s[i]             # Get the current character.

            if c.isdigit():     # If the current character is a digit, convert it to an integer and add to 'curr'.
                curr = (curr * 10) + ord(c) - ord('0')

            if (not c.isdigit() and c != " ") or i == len(s) - 1:
                # If the current character is not a digit and not a space, or if it's the last character,
                # it means we have reached the end of a number or an operator.
                # Perform the operation based on the last encountered operator.

                if lastSign == '+':
                    stack.append(curr)    # If the last operator was '+', add 'curr' to the stack.
                elif lastSign == '-':
                    stack.append(-1 * curr)  # If the last operator was '-', add the negation of 'curr' to the stack.
                elif lastSign == '*':
                    temp = stack.pop() * curr  # If the last operator was '*', pop the top element from the stack,
                    stack.append(temp)         # multiply it with 'curr', and add the result back to the stack.
                elif lastSign == '/':
                    temp = stack.pop() / curr  # If the last operator was '/', pop the top element from the stack,
                    stack.append(int(temp))    # perform division (integer division), and add the result back to the stack.

                lastSign = c   # Update the last operator to the current character.
                curr = 0       # Reset 'curr' for the next number.

        while stack:    # Once the loop is done, perform the final addition of all the elements in the stack.
            result += stack.pop()

        return result   # Return the final result.
