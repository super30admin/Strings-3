# Leetcode problem link : https://leetcode.com/problems/basic-calculator-ii/
# Time Complexity:    O(n) 
# Space Complexity:   O(n)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
      In order to make sure operator precedence is taken into account, we use stack to store all the values (generalized in the form of addition).
      Keep pushing the element if sign below the number was +, push negated element if it was -
      For * and /, pop the last element, perform the operation and then push
      
      Once all the elements are processed, just pop and add and return result
''' 
class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        stack = []
        num = 0
        last_sign = '+'
        
        for i,x in enumerate(s):
            if x.isdigit():
                num = num * 10 + int(x)
            # this condition makes sure last element is processed and pushed to stack, as there won't be any operator after it
            if (x != ' ' and not x.isdigit()) or i == len(s) - 1:
                if last_sign == '+':
                    stack.append(num * 1)
                elif last_sign == '-':
                    stack.append(num * -1)
                elif last_sign == '*':
                    stack.append(int(stack.pop() * num))
                elif last_sign == '/':
                    stack.append(int(stack.pop() / num))
                last_sign = x
                num = 0
        
        result = 0
        
        while stack:
            result += stack.pop()
        
        return result