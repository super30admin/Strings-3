# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def calculate(self, s: str) -> int:
        res = 0
        lastSign = "+"  
        currNum = 0
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isnumeric():
                currNum = currNum * 10 + int(c)
            
            if (c != ' ' and not c.isnumeric()) or i == len(s) - 1:
                if lastSign == "+": 
                    res = res + currNum
                    tail = +currNum
                elif lastSign == "-":
                    res = res - currNum
                    tail = -currNum
               
                elif lastSign == "*":
                    res = res - tail + tail * currNum
                    tail = tail * currNum
                elif lastSign == "/":
                    res = res - tail + int(tail / currNum)
                    tail = int(tail / currNum)
                currNum = 0
                lastSign = c 
        
        return res