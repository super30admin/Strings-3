# Time: O(N)
# Space: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# if we come across a digit then do num * 10 + int(char) or if not digit put inside stack and process '/' and '*' on stack and later take care of '+' and '-' at last

class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == None:
            return 0
        stack = []
        num = 0
        lastsign = '+'
        result = 0
        
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num * 10 + int(char)
            
            if (not char.isdigit() and not char == ' ') or i == len(s) - 1: # my i last index
                if lastsign == '+':
                    stack.append(num)
                elif lastsign == '-':
                    stack.append(-num)
                elif lastsign == '*':
                    stack.append(stack.pop() * num)
                elif lastsign == '/':
                    stack.append(int(stack.pop() / num)) # int important 3/2 -> 1.5 but using int 1
                num = 0
                lastsign = char
                
        while len(stack) != 0:
            result += stack.pop()
        
        return result
