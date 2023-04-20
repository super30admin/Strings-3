# Time Complexity - O(n)
# Space Complexity - O(n)

class Solution:
    def calculate(self, s: str) -> int:
        curr = 0
        stack = []
        lastsign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                curr = curr * 10 + int(s[i])
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s) - 1:
                if lastsign == '+':
                    stack.append(curr)
                elif lastsign == '-':
                    stack.append(-curr)
                elif lastsign == '*':
                    stack.append(stack.pop() * curr)
                elif lastsign == '/':
                    stack.append(int(stack.pop() / curr))
                lastsign = s[i]
                curr = 0
        res = 0
        while stack:
            res += stack.pop()
        return res
