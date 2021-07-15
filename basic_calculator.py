# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def calculate(self, s):
        stack = []
        sign = "+"
        res = 0
        curr = 0

        # check if string is null return 0
        if not s:
            return 0

        #  or else iterate over string and check if it is digit and if then append
        #  to the current number and if not then we will chekc for white space edge case
        #  and depending upon the last sign we will update the stack an din the end we will
        #  update the current element and sign
        for i in range(len(s)):

            if s[i].isdigit():
                curr = curr * 10 + int(s[i])

            if s[i] != " " and not s[i].isdigit() or i == len(s) - 1:

                if sign == "-":
                    stack.append(-curr)

                elif sign == "+":
                    stack.append(curr)

                elif sign == "*":
                    stack.append(int(stack.pop() * curr))

                elif sign == "/":
                    stack.append(int(stack.pop() / curr))

                sign = s[i]
                curr = 0

        while stack:
            res += stack.pop()

        return int(res)

