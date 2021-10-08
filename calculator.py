# // Time Complexity :O(n),n is the length of string
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
class Solution:
    def calculate(self, s: str) -> int:
        lastsign='+'
        curr=0
        calc=0
        tail=0
        s=s.strip()
        n=len(s)
        print(s)
        for i in range(len(s)):
            if s[i].isdigit():
                curr=(curr*10)+int(s[i])
            if (not s[i].isdigit() or i==len(s)-1) and s[i] is not " ":
                if lastsign=='+':
                    calc=calc+curr
                    tail=curr
                elif lastsign=='-':
                    calc=calc-curr
                    tail=-curr
                elif lastsign=='*':
                    calc=(calc-tail)+(curr*tail)
                    tail=curr*tail
                elif lastsign=='/':
                    calc=(calc-tail)+(int(tail/curr))
                    tail=int(tail/curr)
                lastsign=s[i]
                curr=0
                print(tail)
                print(calc)
        return calc