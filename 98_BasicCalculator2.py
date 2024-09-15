# Accepted on leetcode(227)
# time - O(N)
# space - O(N), stack space
class Solution:
    def calculate(self, s: str) -> int:
        # Declaring variables
        stack = []
        num = 0
        lastSign = '+'
        # Iterating over the string s
        for i in range(len(s)):
            c = s[i]  # taking character by character
            if c.isnumeric():  # if number in character convert it to number.
                num = num * 10 + int(c)
            # what to do when we encounter different sign's in calculator.
            if not c.isnumeric() and c != ' ' or i == len(s) - 1:
                if lastSign == '+':
                    stack.append(num)
                if lastSign == '-':
                    stack.append(-num)
                if lastSign == '*':
                    stack.append(stack.pop() * num)
                if lastSign == '/':
                    tmp = stack.pop()
                    # number popped is negative and not exactly divisible by the number then add one to the output
                    if tmp // num < 0 and tmp % num != 0:
                        stack.append(tmp // num + 1)
                    else:
                        stack.append(tmp // num)
                lastSign = c
                num = 0
        # calculate the sum for rest of the stack items
        sum = 0
        while stack:
            sum += stack.pop()

        return sum
