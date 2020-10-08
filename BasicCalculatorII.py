class Solution:
    # Time Complexity - O(N)
    # Space Compexity - O(N)
    # Solution 1 - Using stack
    def calculate(self, s):
        if len(s) == 0:
            return 0
        output = 0
        num = 0
        last_sign = "+"
        stack = []
        numbers = "0123456789"
        for i in range(len(s)):
            if s[i] in numbers:
                val = int(s[i])
                num = num * 10 + val
            if (s[i] not in numbers and s[i] != " ") or i == len(s)-1:
                if last_sign == "+":
                    stack.append(num* 1)
                elif last_sign == "-":
                    stack.append(num * -1)
                elif last_sign == "*":
                    stack.append(stack.pop()*num)
                elif last_sign == "/":
                    stack.append(int(stack.pop()/num))    
                num = 0
                last_sign =  s[i]
        while stack:
            output += stack.pop()
            
        return output
                    
                
    
        