# Time complexity: O(n) where n = len(s)
# Space complexity: O(m) where m = no.of.integers(length of stack)
# Approach: whenever the value is number, update the num
# if the value is not num and not space or last index of string, we have to calculate
# check for last num and compute the value of number to be appended to stack
# if the last num is * or / , then pop the top of stack and * or / number to it and push it
# else push the + or - num
# after the string traversal, add all the elements from stack by popping it from top
# return the added answer.

class Solution:
    def calculate(self, s: str) -> int:
        s.strip()
        lastsign = '+'
        calc, num = 0,0
        stack = []
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + int(c)
            if((not c.isdigit() and  c != ' ') or (i == len(s)-1)):
                if lastsign == '+':
                    stack.append(num)
                elif lastsign == '-':
                    stack.append(-num)
                elif lastsign == '*':
                    n = stack.pop()
                    stack.append(n*num)
                elif lastsign == '/':
                    n = stack.pop()
                    stack.append(int(n/num))
                    # print(calc)
                lastsign = c
                num = 0
                
        while stack:
            calc= calc + stack.pop()
        return calc
                    
        