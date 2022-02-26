"""
Given a string s which represents an expression, 
evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. 
All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function 
which evaluates strings as mathematical expressions, such as eval().
"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def calculate(self, s: str) -> int:
        
        #null case
        if s == None or len(s) == 0:
            return 0
        
        #s = s.strip()
        result = 0
        curr = 0
        st = []
        lastsign = "+"
        
        for i in range(len(s)):
            
            if s[i].isdigit():
                curr = curr * 10 + int(s[i])
                
            if (not s[i].isdigit()) and s[i] != " " or i == len(s) - 1:
                
                if lastsign == '+':
                    st.append(curr)

                elif lastsign == '-':
                    st.append(-curr)

                elif lastsign == '*':
                    st.append(st.pop() * curr)

                else:
                    st.append(int(st.pop() / curr))
                lastsign = s[i]
                curr = 0
                
        result = 0
        
        while st:
            result += st.pop()
        return result
        
        
            
                
                
        

