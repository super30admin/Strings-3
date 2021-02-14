# -*- coding: utf-8 -*-
"""
TC:O(N) as we traverse through the given list to process all elements
SC:O(N) recursive stack
"""

class Solution:
    def calculate(self, s: str) -> int:                
	    
		# add "=" in the end to trigger last operation on last num within loop
        s = s.replace(' ', '') + "="     
        num = 0
        op = ""
        res = 0
        last = 0                
        for x in s:
            if x.isdigit():
                num = num * 10 + int(x)
            else:
				# when we find new "op" sign we conduct operation on last num and last known "op", not current one
                if op == "":
                    last = num
                elif op == "+":                    
                    res += last
                    last = num                        
                elif op == "-":
                    res += last
                    last = -num                
                elif op == "*":
                    last *= num                        
                elif op == "/":
                    last = int(last / num)
                op, num = x, 0
		
		# add last (last op on last num) to the result
        return res + last
    
S = Solution()
print(S.calculate("3+3/0"))