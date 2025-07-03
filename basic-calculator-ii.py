# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def calculate(self, s: str) -> int:
        s = s.replace(' ', '')
        stack = []
        num = 0
        sign = '+'
        n = len(s)
        for i, c in enumerate(s):
            if c.isdigit():
                num = num * 10 + int(c)
            if c in '+-*/' or i == n - 1:
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == '*':
                    stack.append(stack.pop() * num)
                elif sign == '/':
                    prev = stack.pop()
                    # Truncate toward zero
                    stack.append(int(prev / num))
                sign = c
                num = 0
        return sum(stack)
        