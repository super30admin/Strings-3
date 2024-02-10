# Problem2 Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

class Solution:
    def calculate(self, s: str) -> int:
        s = s.strip()
        st = []
        lastEx = '+'
        curr = calc = 0
        for i in range(len(s)):
            if s[i].isdigit():
                curr = curr * 10 + int(s[i]) #if its a multiple digit number
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s)-1:
                if lastEx == '+':
                    st.append(curr)
                elif lastEx == '-':
                    st.append(-curr)
                elif lastEx == '*' :
                    st.append(st.pop() * curr)
                else:
                    ele = st.pop()
                    if ele < 0:
                        st.append(-(-ele // curr))
                    else:
                        st.append(ele // curr)
                lastEx = s[i]
                curr = 0
        print(st)
        while st:
            calc += st.pop()
        return calc
# time complexity O(n)
# space complexity O(n)