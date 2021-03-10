"""
227. Basic Calculator II
Time Complexity - O(n)
Space Complexity - O(n) where n is no of digits stores in stack
Here we are using a stack that will store digits.
If operation is addition directly push prev number to stack
If operation is substraction push negative of number into stack
If operation is multiplication pop last elemnt in stack multiply with new digit and push back in stack
If operation is division pop last elemnt in stack divide with new digit and push back in stack
When string length is traversed add all numbers in stack and return output"""
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        num = 0
        sign = '+'
        i = 0
        while(i < len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            
            if s[i] != ' ' and  not s[i].isdigit() or i == len(s)-1 :
                if (sign == '+'):
                    stack.append(num)
                elif (sign == '-'):
                    stack.append(-num)
                elif (sign == '*'):
                    temp = stack.pop()
                    stack.append(temp * num)
                elif (sign == '/'):
                    temp = stack.pop()
                    if temp > 0:
                        stack.append(temp//num)
                    else:
                        stack.append(-1*((-temp)//num))
                
                sign = s[i]
                num = 0
            i += 1
            
        i = 0
        output = 0
        while(stack):
            output += stack.pop()
        return output