"""
Time complexity: O(n) - where 'n' is the length of the string.
Space Complexity: O(m) - where 'm' is the number of integers that goes into the stack.
Yes, the code worked on leetcode.
Issues while coding - No
"""


class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s)==0:
            return 0
        s = s.strip()
        lastSign = "+"
        calc,num = 0,0
        st =  []
        
        for i in range(len(s)):
            c = s[i]
            if  c.isdigit():
                num = num * 10 + int(c)
                
            if (not c.isdigit() and c!=' ') or (i==len(s)-1):
                if lastSign == "+":
                    st.append(num)
                elif lastSign == "-":
                    st.append(-num)
                elif lastSign == "*":
                    n = st.pop()
                    st.append(int(n*num))
                elif lastSign == "/":
                    n = st.pop()
                    st.append(int(n/num))
                lastSign = c
                num = 0
        
        while st:
            calc = calc+st.pop()

        return calc
                
        