# TC - O(n) - One pass for the length of the string
# SC - O(n) - stack size worst case all elements into stack but with given constraints will be O(n/2) at most but asymptotically O(n)
class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0:
            return -1
        
        stack = []
        num = 0
        result = 0
        lastSign = "+"
        for i in range (len(s)):
            
            char = s[i]
            if char.isdigit():
                num = num * 10 + int(char)
                 
            if ((not char.isdigit() and char != " " ) or i == len(s) - 1):
                if lastSign == "+":
                    stack.append(num)
                elif lastSign == "-":
                    stack.append(-num)
        
                elif lastSign == "*":
                    
                    stack.append( stack.pop() * num)
                else:
                    popped = stack.pop()
                    stack.append(int(popped / num))
                
                
                num = 0
                lastSign = char
                 
        return sum(stack)
                