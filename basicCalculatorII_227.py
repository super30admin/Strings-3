# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes

# // Your code here along with comments explaining your approach: 
#Keep going on until we hit an operator. If at last index, push it to the stack. Maintain the signs, initialised by +. Every time you see * or / reset the num and pop the num, perform operation and push to stack.

class Solution:
    def calculate(self, s: str) -> int:
        
        if len(s)==0:
            return 0
        
        stack = []
        num=0
        last_sign = '+'
        
        for x in range(len(s)):
            ch = s[x]
            #if char is digit, calculate the number formed till now
            if ch.isdigit():
                num = num*10 + int(ch)
                
            if (not ch.isdigit() and ch != ' ') or x ==len(s)-1:
                if last_sign == '+':
                    stack.append(num*1)
                elif last_sign == '-':
                    stack.append(num*-1)
                elif last_sign == '*':
                    stack.append(stack.pop()*num)
                elif last_sign == '/':
                    stack.append(int(stack.pop() / num))
                
                num =0
                last_sign = ch
        
                
        output = 0
        while stack:
            output += stack.pop()
            
        return output
            
