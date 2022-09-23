# Stack Solution
class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0
        st = []
        calc = 0
        lastsign = '+'
        curr = 0

        for i in range(len(s)):
            c = s[i]

            if c.isnumeric():
                curr = curr * 10 + int(c)
            if (not c.isnumeric() and c != " ") or i == len(s) - 1:
                # print(1234567)
                if lastsign == '+':
                    st.append(curr)
                elif lastsign == '-':
                    st.append(-curr)
                elif lastsign == '*':
                    st.append(st.pop() * curr)
                elif lastsign == '/':
                    st.append(int(st.pop() / curr))

                curr = 0
                lastsign = c
        # print(st)
        while len(st) > 0:
            calc += st.pop()
        return print(calc)


# Time Complexity = O(n)
# Space Complexity = O(n)


if __name__ == "__main__":
    obj = Solution()
    obj.calculate(" 3/2 ")
# output : 1


# Time Complexity = O(N)
# Space Complexity = O(n). Size of the stack/list
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
