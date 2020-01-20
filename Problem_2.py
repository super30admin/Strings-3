# Runs on Leetcode
    # n is length of string
      # Runtime - O(n)
      # Memory - O(n)

class Solution:
    def calculate(self, s: str) -> int:
        if not s:
            return 0
        
        stack = []
        num = 0
        sign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                num = (num*10)+int(s[i])
            if not s[i].isdigit() and s[i] != " "  or i == len(s)-1:
                if sign == '+':
                    stack.append(num)
                if sign == '-':
                    stack.append(-num)
                if sign == '*':
                    a = stack.pop()
                    stack.append(a*num)
                if sign == '/':
                    a = stack.pop()
                    stack.append(int(a/num))
                num = 0
                sign = s[i]
        return int(sum(stack))
