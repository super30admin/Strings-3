"""
Time complexity O(N)
Space complexity O(N)

"""

class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s)==0:
            return 0
        n=len(s)
        
        num=0
        lastsign="+"
        st=[]
        
        for i in range(n):
            ch=s[i]
            if(ch.isdigit()):
                num=num*10+int(ch)
            if(not ch.isdigit() and ch!=" " ) or i==n-1:
                if(lastsign=="+"):
                    st.append(num)
                elif(lastsign=="-"):
                    st.append(-num)
                elif(lastsign=="*"):
                    st.append(st.pop()*num)
                elif(lastsign=="/"):
                    st.append(int(st.pop()/num))
                num=0
                lastsign=ch
        res=0
        while(st):
            res+=st.pop()
        return res
                
                