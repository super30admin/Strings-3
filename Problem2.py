## Problem2 

# Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)
class Solution:
    def calculate(self, s: str) -> int:
        """
        Time Complexity: O(N)
        - N is the length of the string 's'. 
        - We iterate through the string exactly once. Stack operations (append/pop) 
          take O(1) time.
        
        Space Complexity: O(N)
        - In the worst-case scenario (e.g., an expression with only addition or 
          subtraction like "1+2+3+4"), we push all the numbers into the stack.
        """
        stack = []
        curr = 0
        
        # We start with '+' so the first number gets appended to the stack as positive
        lastOperator = '+'
        s = s.strip()
        operators = {'+', '-', '/', '*'}
        n = len(s)
        
        for i in range(n):
            ch = s[i]
            
            # Ignore whitespace
            if ch == ' ':
                continue
            
            # If the character is a digit, build the current number.
            # This handles multi-digit numbers (e.g., '1' followed by '4' becomes 14).
            if ch.isdigit():
                curr = curr * 10 + int(ch)
            
            # If the current character is an operator OR it is the last character in the string,
            # it's time to evaluate the current number based on the LAST operator we saw.
            if i == n - 1 or (ch in operators):
                
                # Push positive number
                if lastOperator == '+':
                    stack.append(curr)
                
                # Push negative number
                elif lastOperator == '-':
                    stack.append(-curr)
                
                # Pop the top number, multiply by current, and push the result back
                elif lastOperator == '*':
                    op1 = stack.pop()
                    stack.append(op1 * curr)
                
                # Pop the top number, divide by current, and push back.
                # Note: int(op1 / curr) is used instead of op1 // curr because 
                # Python's floor division (//) rounds down (e.g., -3 // 2 = -2), 
                # but the problem requires truncating toward zero (e.g., int(-1.5) = -1).
                else:
                    op1 = stack.pop()
                    stack.append(int(op1 / curr))
                
                # Reset the current number and update the last operator
                curr = 0
                lastOperator = ch
                
        # At the end, the stack contains all the processed terms (products, quotients,
        # and standalone numbers). Adding them all together gives the final result.
        res = 0
        while stack:
            res += stack.pop()
            
        return res