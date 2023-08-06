"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Basic Calculator II

# Approach - 1
# With Stack

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return s
        lastSign="+"
        n=len(s)
        curr=0
        st=[]
        # s=s.replace(" ","")
        for i in range(len(s)):
            c=s[i]
            if c.isdigit():
                curr=curr*10+ord(c)-ord('0')
                
            if not c.isdigit() and c!=" "or i==n-1:
                if lastSign=="+":
                    st.append(curr)
                elif lastSign=="-":
                    st.append(-curr)
                elif lastSign=="*":
                    mult=st.pop()*curr
                    st.append(mult)
                elif lastSign=="/":
                    mult=int(st.pop()/float(curr))
                    # if mult<0:
                    #     mult+=1
                    
                    st.append(mult)
                lastSign=c
                curr=0
        result=0
        while st:
            result+=st.pop()
        return result
    
# Approach - 2
# Without Stack

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return s
        lastSign="+"
        n=len(s)
        curr=0
        calc,tail=0,0
        for i in range(len(s)):
            c=s[i]
            if c.isdigit():
                curr=curr*10+ord(c)-ord('0')
            if not c.isdigit() and c!=" "or i==n-1:
                if lastSign=="+":
                    calc+=curr
                    tail=curr
                elif lastSign=="-":
                    calc-=curr
                    tail=-curr
                elif lastSign=="*":
                    calc=calc-tail+tail*curr
                    tail=tail*curr
                elif lastSign=="/":
                    calc=calc-tail+int(tail/float(curr))
                    tail=int(tail/float(curr))
                lastSign=c
                curr=0

        return calc