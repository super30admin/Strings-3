class Solution:
    def calculate(self, s: str) -> int:
        s = s.strip()
        st = []
        curr = 0
        lastExp = "+"
        res = 0
        n = len(s)

        for i in range(n):
            if s[i].isnumeric():
                curr = 10 * curr + (ord(s[i]) - ord('0'))
            
            if (not s[i].isnumeric() and s[i] != " ") or i == n - 1:
                if lastExp == "+":
                    st.append(curr)
                elif lastExp == "-":
                    st.append(-1 * curr)
                elif lastExp == "*":
                    st.append(st.pop() * curr)
                elif lastExp == "/":
                    st.append(int(st.pop() / curr))
                
                lastExp = s[i]
                curr = 0

        while st:
            res += st.pop()

        return res
