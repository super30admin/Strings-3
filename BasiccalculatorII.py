# Time Complexity : O(N) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to calculate each operator and digit in each string without any stack by tail and current value.

class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return
        s = s.replace(" ", "")
        lastsig='+'
        curr,calc,tail=0,0,0
        n=len(s)
        for i in range(0,n):
            c=s[i]
            if(c.isdigit()):
                curr= curr*10+int(c)
            if (( not c.isdigit() and c != ' ') or i == n-1):
                if (lastsig == '+'):
                    calc +=curr
                    tail = curr
                elif (lastsig == '-'):
                    calc -= curr
                    tail = -curr
                elif (lastsig == '*'):
                    calc = calc - tail +(tail*curr)
                    tail = tail*curr
                else:
                    calc = calc - tail +int(tail/curr)
                    tail = int(tail/curr)
                curr = 0
                lastsig=c
        return int(calc)
