# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def calculate(self, s: str) -> int:
        s=s.strip()
        
        lastsign="+"
        tail=0
        calc=0
        num=0
        
        for i in range(len(s)):
            if s[i].isnumeric():
                if int(s[i])<0:
                    num=num*10-int(s[i])
                else:
                    num=num*10+int(s[i])
                    
            if (s[i]!=" " and (not s[i].isnumeric() or i==len(s)-1)):
                if lastsign=="+":
                    tail=num
                    calc+=num
                    num=0
                elif lastsign=="-":
                    tail=-1*num
                    calc-=num
                    num=0
                elif lastsign=="*":
                    calc=(calc-tail)+tail*num
                    tail=tail*num
                    num=0
                elif lastsign=="/":
                    calc=(calc-tail)+int(tail/num)
                    tail=int(tail/num)
                    num=0
                lastsign=s[i]
        return calc
