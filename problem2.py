#Time And Space Complexity O(N)

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
