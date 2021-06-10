# TC: O(N) since we are iterating over all the characters of the string. 
# SC: O(N) where N would be the size of the stack and in worst case, we would end up entering all the numbers/characters of string in the stack.

class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0: 
            return
        
        s = s.strip()
        stack = []
        num = 0 
        lastSign = '+'
        for i in range(len(s)):
            if s[i] == ' ': 
                continue
                
            if s[i].isdigit(): 
                num = (num * 10) + int(s[i])
                # print(num)
            
            if not s[i].isdigit() or i == len(s) - 1:
                if lastSign == '+': 
                    stack.append(num)
            
                elif lastSign == '-': 
                    stack.append(-num)
            
                elif lastSign == '*':
                    stack.append(stack.pop() * num)
                
                else:
                    prev = stack.pop()
                    calc = int(prev / num)
                    stack.append(calc)
                
                lastSign = s[i]
                num = 0
        
        result = 0
        while stack: 
            result += stack.pop()
        
        return result
