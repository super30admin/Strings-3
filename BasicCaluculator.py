-------------------------------- Basic Calculator ---------------------------------------------
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I used a dict to store the calculated values of the expression with more precedence operators like '*' and '/'. 
#I will store the prev sign and prev value. once i reach the '*' or '/' as my prev sign , I will take the top value of stack and 
#evaluate expression with prev val and append that to the stack, so that stack will have evaluated values of multiplication and division 
#and at last add the remaining elements in the stack.
 

class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        
        prevval = 0
        prevsign = '+'

        stack = []
        for i in range(len(s)):
            curr = s[i]
            if curr.isdigit():
                prevval = (prevval*10)+int(curr)
                
            if (curr.isdigit() == False and curr != ' ') or i == len(s)-1 :
                if prevsign == '+':
                    stack.append(prevval)
                elif prevsign == '-':
                    stack.append(-prevval)
                elif prevsign == '*':
                    stack[-1]*=prevval
                elif prevsign == '/':
                    stack[-1] = int(float(stack[-1])/prevval)
                prevval = 0
                prevsign = curr
        return sum(stack)