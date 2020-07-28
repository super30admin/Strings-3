"""
// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this : no
"""
class Solution:
    def calculate(self, s: str) -> int:
        #intialization
        num = 0 #keeps track of the current number
        last_sign = "+"
        st = []
        
        for i in range(len(s)):
            
            if s[i].isdigit(): 
                num = num * 10 + int(s[i]) #till we find digits one after other, form the number
               
                
            if not s[i].isdigit() and s[i] != " "or i == len(s) - 1:
                if last_sign == "+": #operations are performed based on the last sign
                    st.append(num)
                    
                elif last_sign == "-":
                    st.append(-1 * num)
                #so that BODMAS is followed

                elif last_sign == "*":
                    tmp = st.pop()
                    st.append(tmp * num)
                    
                elif last_sign == "/":
                    tmp = st.pop()
                    st.append(int(tmp / num))
                
                num = 0
                
                last_sign = s[i]
                
        return sum(st)