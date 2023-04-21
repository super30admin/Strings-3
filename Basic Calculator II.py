class Solution:
    # Time: O(n)
    # Space: O(n)
    def calculate(self, s: str) -> int:
        st = []
        currnum = 0
        sign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                currnum = currnum * 10 + int(s[i])
                # print(currnum)
            if (not s[i].isdigit() and s[i] != " ") or i == len(s) - 1:
                if sign == '+':
                    st.append(currnum)

                elif sign == '-':
                    st.append(-currnum)

                elif sign == '*':
                    popped = st.pop()
                    st.append(currnum * popped)

                else:
                    popped = st.pop()
                    st.append(int(popped / currnum))

                currnum = 0
                sign = s[i]
                # print(st)

        # result = 0
        # for ele in st:
        #     result += ele
        # print(st)
        return sum(st)