# Time Complexity : O(n), n = length of the string
# Space Complexity : O(n), for the stack used to store intermediate numbers
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Append a '+' at the end of string to force processing of the last number.
# 2. Use `PreSign` to track the previous operator and apply it when the next operator is found.
# 3. Use a stack to handle order of operations: *, / evaluated immediately, + and - pushed to stack.
# 4. At the end, sum all values in the stack to get the final result.
# 5. Division uses math.trunc to simulate integer division towards zero as required.

import math

class Solution:
    def calculate(self, s: str) -> int:
        num, PreSign, stack = 0, '+', []
        for c in s + '+':  # Add a '+' to process the last number
            if c.isdigit():
                num = num * 10 + int(c)
            elif c in "+-*/":
                if PreSign == '+':
                    stack.append(num)
                elif PreSign == '-':
                    stack.append(-num)
                elif PreSign == '*':
                    stack.append(stack.pop() * num)
                elif PreSign == '/':
                    stack.append(math.trunc(stack.pop() / num))
                PreSign = c  # update previous sign
                num = 0  # reset number
        return sum(stack)