# Time Complexity : O(N) where N is the length of the string.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def calculate(self, s: str) -> int:
        s = s.strip(" ")
        lastSign = '+'
        currNum = 0
        tail = 0
        result = 0
        
        for i in range(len(s)):
            if s[i] != ' ':
                if s[i].isdigit():
                    currNum = currNum * 10 + int(s[i])
                if not s[i].isdigit() or i == len(s) - 1:
                    if lastSign == '+':
                        result += currNum
                        tail = currNum
                    elif lastSign == '-':
                        result -= currNum
                        tail = - currNum
                    elif lastSign == '*':
                        result = result - tail + tail * currNum
                        tail = tail * currNum
                    elif lastSign == '/':
                        result = result - tail + int(float(tail) / float(currNum))
                        tail = int(float(tail) / float(currNum))
                    currNum = 0
                    lastSign = s[i]
        
        return result