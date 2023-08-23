class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def calculate(self, s: str) -> int:
        stack = []
        s = s.strip()
        lastsign = "+"
        curr = 0

        for i in range(len(s)):
            if s[i].isdigit():
                curr = curr * 10 + int(s[i])
            if s[i] in "+-*/" or i == len(s) - 1:
                if lastsign == "+":
                    stack.append(curr)
                elif lastsign == "-":
                    stack.append(-curr)
                elif lastsign == "*":
                    stack[-1] = stack[-1] * curr
                elif lastsign == "/":
                    if stack[-1] < 0:
                        stack[-1] = -(-stack[-1] // curr)
                    else:
                        stack[-1] = stack[-1] // curr

                curr = 0
                lastsign = s[i]

        return sum(stack)
