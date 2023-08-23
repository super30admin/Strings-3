#tc-O(n),sc-O(n)
class Solution:
    def calculate(self, s: str) -> int:
        if s == '0':
            return 0
        lastSign = '+'
        curr = 0 
        st = []
        for i,ch in enumerate(s):
            if ch.isdigit():
                curr = curr*10 + (ord(ch) - ord('0'))
            if (not ch.isdigit() and ch!=" ") or i == len(s)-1:
                if lastSign =='+':
                    st.append(curr)
                elif lastSign =='-':
                    st.append(-curr)
                elif lastSign == '*':
                    st.append(st.pop()*curr)
                else:
                    st.append(int(st.pop()/curr))
                curr = 0
                lastSign = ch
        return sum(st)
