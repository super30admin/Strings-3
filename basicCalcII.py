# Time Complexity : O(N) n = length of string
# Space Complexity : O(N/2) half of the string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes.    
#   val = int(stack.pop() / num) is different from stack.pop()//num



# Your code here along with comments explaining your approach

class Solution:
    def calculate(self, s: str) -> int:
        """
        iterate through the string. 
        put in stack when not digit
            - at last element we process instock
        if digit.. keep processing the number
        
        just add whats left in the stack
        """
        if not s:
            return 0
        
        lastSign = '+'
        stack = []
        num = 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + ord(c) - ord('0')

            if not c.isdigit() and c != ' ' or i == len(s)-1:
                if lastSign == '+':
                    stack.append(num)
                elif lastSign == '-':
                    stack.append(-num)
                elif lastSign == '*':
                    val = stack.pop() * num
                    stack.append(val)
                elif lastSign == '/':
                    val = int(stack.pop() / num)
                    stack.append(val)
            
                num = 0
                lastSign = c
        res = 0
        while stack:
            val = stack.pop()
            res += val
            
        return res
            
                