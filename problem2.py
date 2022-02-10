
Approach 1: Using Stack
# Time Complexity : O(n)
# # Space Complexity:o(n)
# #  Did this code successfully run on Leetcode : Yes

class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0

        lSign = "+"
        curr = 0
        stack = []

        for i in range(0,len(s)):
            c = s[i]

            if c.isdigit():
                curr =  curr*10+ ord(c) -ord("0")

            if (c.isdigit()== False and c != " ") or i == len(s)-1:
                if lSign == "+":
                    stack.append(curr)

                elif lSign == "-":
                    stack.append(-curr)

                elif lSign == "*":
                    stack.append(stack.pop() * curr)

                else:
                    stack.append(stack.pop() * curr)

                lSign = c
                curr = 0

        result = 0
        while stack:
            result += stack.pop()

        return result


Approach 2: using tail and calc variable
# Time Complexity : O(n)
# # Space Complexity:o(1)
# #  Did this code successfully run on Leetcode : Yes

class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0

        lSign = "+"
        curr = 0

        calc = 0
        tail = 0

        for i in range(0,len(s)):
            c = s[i]

            if c.isdigit():
                curr =  curr*10+ ord(c) -ord("0")

            if (c.isdigit()== False and c != " ") or i == len(s)-1:
                if lSign == "+":
                    calc = curr + calc
                    tail = curr

                elif lSign == "-":
                    calc = calc - curr
                    tail = -curr

                elif lSign == "*":
                    calc = calc - tail + tail * curr
                    tail = tail * curr
                else:
                    calc = calc - tail + tail / curr
                    tail = tail / curr

                lSign = c
                curr = 0

        return calc



