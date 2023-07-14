'''
Problem:  Basic Calculator II
Time Complexity: O(n), where n is length of string
Space Complexity: O(n), for stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        put digits on the stack
        whenever the operator + and - encounter then push to the stack
        whenever * and /, then process it with top element in the stack
'''

class Solution:
    def calculate(self, s: str) -> int:
        if len(s)==0:
            return 0
        stack = []
        curr = 0
        operator = '+'
        result = 0

        for i in range(len(s)):
            if s[i].isdigit():
                curr = curr * 10 + ord(s[i])-ord("0")
            
            if (not s[i].isdigit() and not s[i].isspace()) or i == len(s)-1:
                if operator == '+':
                    stack.append(curr)
                elif operator == '-':
                    stack.append(-curr)
                elif operator == '*':
                    stack.append(stack.pop() * curr)
                else:
                    tmp = stack.pop()
                    if tmp//curr < 0 and tmp%curr != 0:
                        stack.append(tmp//curr+1)
                    else:
                        stack.append(tmp//curr)
                operator = s[i]
                curr = 0
        
        while stack:
            result+=stack.pop()
        
        return result