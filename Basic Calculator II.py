# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def calculate(self, s: str) -> int:
        cur = 0
        stack = []
        last_op = "+"
        result = 0
        for i in range(len(s)):
            if s[i].isnumeric():
                cur = cur * 10 + int(s[i])
            if (i == len(s)-1 or (s[i] != " ") and not s[i].isnumeric()):
                if last_op == "+":
                    stack.append(cur)
                elif last_op == "-":
                    stack.append(-cur)
                elif last_op == "*":
                    cur *= stack.pop()
                    stack.append(cur)
                elif last_op == "/":
                    temp = stack.pop()
                    temp /= cur
                    stack.append(int(temp))
                cur = 0
                last_op = s[i]
        while len(stack) > 0:
            result += stack.pop()
        return result
            
