# Time Complexity : O(N)
# Space Complexity : O(N/2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Initialize stack and presign and num to + and 0.
# Iterate over the string and check if the character is digit or not
# If the character is digit then convert charcter to int and add it to num * 10 for multiple digit numbers
# If it is not digit or i is at the last index of the string then check for +-*/ and put the +num or -num into stack if + or -
# If it is * or / then pop the stack, * or / with num and add it back to stack and assign presign to current sign and num to 0
# Return the sum of stack

import math


class Solution:
    def calculate(self, s: str) -> int:
        num = 0
        presign = "+"
        stack = []
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            #processing and putting things in stack
            if s[i] in "+-*/" or i == len(s) - 1:
                if presign == '+':
                    stack.append(num)
                if presign == '-':
                    stack.append(-num)
                if presign == '*':
                    stack.append(stack.pop() * num)
                if presign == '/':
                    stack.append(math.trunc(stack.pop() / num))
                presign = s[i]
                num = 0
        return sum(stack)
