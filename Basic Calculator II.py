# Time Complexity : O(n)
# Space Complexity : O(n) to maintain the stack
# The code ran on LeetCode

# Keep track of current value seen so far and the previous expression seen. When a new expression is seen, evaluate the previous if needed and append the calculated value to the stack. At the end, sum all the elements remaining in the stack.

class Solution:
    def calculate(self, s: str) -> int:
        cur = 0
        lastExp = '+'
        stack = []
        n = len(s)

        for i in range(len(s)):
            c = s[i]

            if c.isdigit():
                cur = cur * 10 + int(c)
            if (not c.isdigit() and c != ' ') or i == n-1:
                if lastExp == '+':
                    stack.append(cur)
                elif lastExp == '-':
                    stack.append(-1 * cur)
                elif lastExp == '*':
                    temp = stack.pop() * cur
                    stack.append(temp)
                elif lastExp == '/':
                    temp = stack.pop()
                    stack.append(int(temp / cur))
                lastExp = s[i]
                cur = 0
        
        res = 0
        while stack:
            res += stack.pop()
        return res
