"""
Leetcode problem link : https://leetcode.com/problems/basic-calculator-ii/

Approach:
1. In order to make sure operator precedence is taken into account, we use
    stack to store all the values (generalized in the form of addition).
2. Keep pushing the element if sign below the number was +, push negated element if it was -
3. For * and /, pop the last element, perform the operation and then push
4. Once all the elements are processed, just pop and add and return result

Time Complexity: O(n), n is the length of string
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) is 0:
            return 0

        stack = []
        num = 0
        last_sign = '+'

        for i, x in enumerate(s):
            # if x is digit
            if x.isdigit():
                num = num * 10 + int(x)

            # if x is NOT space and NOT digit
            # Also this condition makes sure that last element is processed and
            # pushed to stack as there won't be any operator after it
            if x != ' ' and not x.isdigit() or i == len(s) - 1:
                if last_sign == '+':
                    stack.append(num * 1)
                elif last_sign == '-':
                    stack.append(num * -1)
                elif last_sign == '*':
                    stack.append(int(stack.pop()) * num)
                elif last_sign == '/':
                    stack.append(int(stack.pop()) / num)
                last_sign = x
                num = 0

        result = 0

        # Add all elements in the stack and return
        while stack:
            result += int(stack.pop())

        return result