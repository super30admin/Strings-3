# Basic Calculator II

# Time Complexity : O(N)   
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes, with Runtime: 64 ms and Memory Usage: 16 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : 
"""
Using Stack as a data structure such that operator precedence can be preserved.
On iterating over string check for digit, space or operator. If digit is encountered start 
building number. If operators or space is encountered, A variable last sign 
is initialized to '+' and an empty stack is maintained. Digits are pushed into
stack and last sign is updated with operator. Digits are than popped and result is
returned if the string ends.  

"""
class Solution:
    def calculate(self, s: str) -> int:
        if(len(s)==0 or s==None): # Base Case
            return 0
        st=[] # Stack to store digits
        num=0
        s=s+'+'
        last_sign='+'
        for i in s:
            if i.isdigit():
                num = num*10 + int(i)
            elif i == ' ':
                    pass
            else:
                if last_sign == '+':
                    st.append(num)
                elif last_sign == '-':
                    st.append(-num)
                elif last_sign== '*':
                    st.append(st.pop()*num)
                elif last_sign == '/':
                    st.append(math.trunc(st.pop()/num))
                num=0
                last_sign=i
        return sum(st) 
    
            
      
            
        
