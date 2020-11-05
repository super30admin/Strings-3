# TC: O(N)
# SC: O(N)
# Yes, It ran on Leetcode

class Solution:
    def calculate(self, s: str) -> int:
        
        stack = []
        sign = "+"
        num = 0
        
        for ch in range(len(s)):
            if s[ch].isdigit():
                num = int(s[ch])
            if s[ch] in "+-*/" or ch==len(s)-1:
                if sign=='+':
                    stack.append(num)
                elif sign=='-':
                    stack.append(-num)
                elif sign=='*':
                    num1 = stack.pop()
                    stack.append(num1*num)
                elif sign=="/":
                    num1 = stack.pop()
                    stack.append(num1//num)
                sign = s[ch]
                num = 0
        return sum(stack)