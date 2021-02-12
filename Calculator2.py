"""
## Problem2

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

TIME - O(N)
SPACE - O(N)
"""


class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0
        num = 0
        sign = "+"       # to keep track of current sign
        stack = []
        for i in range(len(s)):
            if s[i].isnumeric():  # if char is a number we process it
                num = num * 10 + (ord(s[i]) - ord('0'))

            if not s[i].isnumeric() and s[i] != ' ' or i == len(s) - 1:    # if we have sign
                if sign == '+':          # if + then push positive num
                    stack.append(+num)

                elif sign == '-':      # if - then push negative num
                    stack.append(num * -1)

                elif sign == '*':      # if * then push pop the top number from stack and perform the mulitpy and store the result to stack
                    stack.append(stack.pop() * num)
                elif sign == '/':
                    if num > 0:
                        stack.append(int(stack.pop() / num))

                sign = s[i]
                num = 0

        result = 0    # add all number of stack as we processed multipy and div in above propcess we have only + or -
        while len(stack) != 0:
            result += stack.pop()
        return result




