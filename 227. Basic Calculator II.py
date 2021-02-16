'''
T = O(n)
S = O(n)
Approach:
we calculate numbers and put them inside stack. We also maintain a last sign. Whenever we see a new sign,
we check for last sign and perform necessary actions.
'''



class Solution:
    def calculate(self, s: str) -> int:
        result = 0
        if not s:
            return result
        stack = []
        num = 0
        lastSign = '+'
        l = len(s)-1
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num*10+int(char)
            if (not char.isdigit() and not char == " ") or i == l:
                if lastSign == '+':
                    stack.append(num)
                elif lastSign == '-':
                    stack.append(-num)
                elif lastSign == "*":
                    stack.append(stack.pop()*num)
                elif lastSign == "/":
                    stack.append(int(stack.pop()/num))
                num = 0
                lastSign = char
        for i in stack:
            result += i
        return result