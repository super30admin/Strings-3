#As taught in class, solving this problem using stack and lastSign to save the last operator to be processed
#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s)==0:
            return 0
        n = len(s)
        num = 0
        st = list()
        lastSign = "+"
        for i in range(n):
            c = s[i]
            if(c.isdigit()):
                num = num*10+int(c)-0
            if((not c.isdigit() and c!= " ") or i == n - 1):
                if lastSign == "+":
                    st.append(num)
                elif lastSign == "-":
                    st.append("-")
                elif lastSign == "*":
                    nn = st.pop(0) * num
                    st.append(nn)
                elif lastSign == "/":
                    nn = st.pop(0) / num
                    st.append(nn)
                num = 0
                lastSign = c
        result = 0
        while(len(st)):
            result += st.pop(0)
        return result