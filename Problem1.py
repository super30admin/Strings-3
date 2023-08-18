# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def calculate(self, s: str) -> int:
        s=s.strip()
        n=len(s)
        lastSign='+'
        curr=0
        calc=0
        for i in range(n):
            c=s[i]
            if c.isdigit():
                curr=curr*10+int(c)
            if (not c.isdigit() and c!=' ') or (i==n-1):
                if lastSign=='+':
                    calc=calc+curr
                    tail=curr
                elif lastSign=='-':
                    calc=calc-curr
                    tail=-curr
                elif lastSign=='*':
                    calc=calc-tail+tail*curr
                    tail=curr*tail
                else:
                    calc=calc-tail+int(tail/curr)
                    tail=int(tail/curr)
                curr=0
                lastSign=c

        return calc