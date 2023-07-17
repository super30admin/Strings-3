# Time Complexity : O(s) where s is the length of the string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
class Solution:
    def calculate(self, s: str) -> int:
        curr = 0
        tail = 0
        lastOp = "+"
        val = 0

        for i in range(len(s) + 1):
            if i == len(s) or s[i] in ["+", "-", "*", "/"]:
                if lastOp == "+":
                    val += curr
                    tail = curr
                if lastOp == "-":
                    val -= curr
                    tail = -curr
                if lastOp == "*":
                    val = val - tail + int(tail * curr)
                    tail = int(tail * curr)
                if lastOp == "/":
                    val = val - tail +  int(tail / curr)
                    tail = int(tail / curr)
                curr = 0
                if i < len(s):
                    lastOp = s[i]
            elif s[i] == " ":
                continue
            else:
                curr = curr*10 + int(s[i])

        return val