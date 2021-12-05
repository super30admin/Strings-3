#Time , space O(n)
class Solution:
    def calculate(self, s: str) -> int:
        #Initialize
        st=[]
        num=0
        last_sign="+"

        for i in range(len(s)):
            c=s[i]
          
            if c.isdigit():
                
                num = num * 10 + int(c)
         #Computation   
            if c=="*" or c=="/" or c=="+" or c=="-" or i==len(s)-1:
                
                if last_sign=="+":
                    st.append(num)
                elif last_sign=="-":
                    st.append(-1*num)
                elif last_sign=="*":
                    st.append(st.pop()*num)
                elif last_sign=="/":
                    st.append(int(st.pop()/num))
                    
                num=0
                last_sign=c
                
        while st:
            num = num+ st.pop()
            
        return num
