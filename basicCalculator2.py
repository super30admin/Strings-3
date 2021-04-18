class Solution:
    def calculate(self, s: str) -> int:
        s = s + "+"
        st = []
        sign = "+"
        num = 0
        for i in s:
            if(i.isnumeric()):
                num = num *10 + int(i)
            elif(i=="+" or i=="-" or i=="*" or i=="/"):
                if(sign=="-"):
                    num = -1*num
                    st.append(num)
                elif(sign=="*"):
                    a = st.pop()
                    st.append(a*num)
                elif(sign=="/"):
                    a = st.pop()
                    if(a<0):
                        a = -1*((a*-1)//num)
                    else:
                        a = a//num
                    st.append(a)
                else:
                    st.append(num)
                num = 0
                sign = i
        return sum(st)
