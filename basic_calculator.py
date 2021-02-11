# Approach:
# Take care of left to right precedence operator 
# perform operation on higher precedence operator and remaining goes to stack

# Time - O(N)
# Space - O(N) # stack space
class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
         
        stack = []
        num = 0
        lastsign = '+'

        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + ord(s[i]) - ord('0')
                
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s) - 1: # we also process when at last index
                
                if lastsign == '+':
                    stack.append(num)
                    
                    
                if lastsign == "-":
                    stack.append(-num)
                
                if lastsign == "*":
                    stack.append(stack.pop() * num)
                    
                
                if lastsign == "/":
                    stack.append(math.trunc(stack.pop() / num))
                
                num = 0
                lastsign = s[i]
                
        answer = 0
        # we only need to process + and - left now

        while len(stack) > 0:
            answer += stack.pop()
        return answer   