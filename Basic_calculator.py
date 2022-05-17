// Time Complexity : O(n) 
// Space Complexity : O(1) recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




class Solution:
    def calculate(self, s: str) -> int:
        res=0
        tail=0
        curr=0
        last_op='+'

        for i in range(0,len(s)):
            ch=s[i]
            if ch.isdigit():
                curr=curr*10+ord(ch)-ord('0')

            if( (not ch.isdigit()) and ch!=' '  or (i==len(s) - 1)):
                if  last_op=='+':
                    res=res+curr
                    tail=curr
                elif  last_op=='-':
                    res=res-curr
                    tail=-curr

                elif  last_op=='*':
                    res=res-tail+tail*curr
                    tail=tail*curr
                elif  last_op=='/':
                    res=res-tail+int(tail/curr)
                    tail=int(tail/curr) 
                last_op=ch
                curr=0
        return res