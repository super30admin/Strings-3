'''
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a stack and append the integers into it. Keep 2 variables val and sign to keep track of the sign and
the value. If we see '-' 5 we put in stack as '-5' if we see * or / we pop from stack and multiply our current val.
Once we go through the string, we just add all values in stack for the answer.
'''
class Solution:
    def calculate(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0

        stack = []

        sign = '+'

        value = 0

        i = 0
        while i < len(s):
            ch = s[i]

            if ch.isnumeric():
                value = value * 10 + (ord(ch) - ord('0'))

            if (not ch.isnumeric() and ch != ' ') or (i == len(s) - 1):
                if sign == '+':
                    stack.append(value)

                if sign == '-':
                    stack.append(-value)

                if sign == '*':
                    num1 = stack.pop()
                    stack.append(num1 * value)

                if sign == '/':
                    num1 = stack.pop()
                    stack.append(int(num1 / value))

                value = 0
                sign = ch
            i += 1
        res = 0
        while len(stack) != 0:
            res += stack.pop()

        return res
