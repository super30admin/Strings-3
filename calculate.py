# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack, cur, op = [], 0, '+'
        for c in s + '+':
            if c == " ":
                continue
            elif c.isdigit():
                cur = (cur * 10) + int(c)
            else:
                if op == '-':
                    stack.append(-cur)
                elif op == '+':
                    stack.append(cur)
                elif op == '*':
                    stack.append(stack.pop() * cur)
                elif op == '/':
                    stack.append(int(stack.pop() / cur))
                cur, op = 0, c
        return sum(stack)
