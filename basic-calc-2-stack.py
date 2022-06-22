# Time Complexity : O(N) where N is the length of the string.
# Space Complexity : O(N) where N is the length of the string.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def calculate(self, s: str) -> int:
        s = s.strip(" ")
        stk = []
        currNum = 0
        lastSign = '+'
        result = 0
        
        for i in range(len(s)):
            if s[i] != ' ':
                if s[i].isdigit():
                    currNum = currNum * 10 + int(s[i])
                if not s[i].isdigit() or i == len(s) - 1:
                    if lastSign == '*':
                        currNum = currNum * stk.pop()
                    if lastSign == '/':
                        currNum = int(float(stk.pop()) / float(currNum))
                    if lastSign == '-':
                        currNum = - currNum
                    stk.append(currNum)
                    currNum = 0
                    lastSign = s[i]

        while len(stk):
            result += stk.pop()

        return result