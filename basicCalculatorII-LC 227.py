# Time Complexity = O(n)
# Space Complexity = O(1)

class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        s = s.strip()       # To trim the extra white spaces
        s = s.replace(" ", "")
        
        
        last_sign = '+'
        calc = 0
        num = 0
        tail = 0
        
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num * 10 + ord(char) - ord('0')
                
                
            if not char.isdigit() and char != '' or i == len(s) - 1:
                if last_sign == '+':
                    calc = calc + num
                    tail = + num
                
                elif last_sign == '-':
                    calc = calc - num
                    tail = - num
                
                elif last_sign == '*':
                    calc = calc - tail + (tail * num)
                    tail = tail * num
                
                else:
                    calc = calc - tail + int(float(tail / num))
                    tail = int(float(tail / num))
                    
                    
                last_sign = char
                num = 0
                
        return calc
   
    
    
# Stack Solution 
# Time Complexity = O(n)
# Space Complexity = O(n), recursive stack

class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        s = s.strip()       # To trim the extra white spaces
        s = s.replace(" ", "")
        
        
        last_sign = '+'
        calc = 0
        num = 0
        stack = []
        
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num * 10 + ord(char) - ord('0')
                
                
            if not char.isdigit() and char != '' or i == len(s) - 1:
                if last_sign == '+':
                    stack.append(num)
                
                elif last_sign == '-':
                    stack.append(- num)
                
                elif last_sign == '*':
                    stack.append(stack.pop() * num)
                
                else:
                    stack.append(int(float(stack.pop() / num)))
                    
                    
                last_sign = char
                num = 0
        
        while stack:
            calc += stack.pop()
                
        return calc