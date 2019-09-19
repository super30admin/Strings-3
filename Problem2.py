# Time Complexity : O(n) when n is length of string s
# Space Complexity :O(n) when n is length of string s
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

class Solution:
    def calculate(self, s: str) -> int:
        # created stack to put thenumbers with sign
        stack = []
        num = 0
        lastsign = "+"

        for idx in range(len(s)):
            char = s[idx]

            # if char is digit then insert it in num
            if char.isdigit():
                num = num * 10 + int(char)

                # if the char is operator or is last digit the go inside push in stack the value
            if (char != " " and not char.isdigit()) or (idx == len(s) - 1):
                if lastsign == '+':
                    stack.append(num)
                elif lastsign == '-':
                    stack.append(-num)
                elif lastsign == '*':
                    stack.append(stack.pop() * num)
                elif lastsign == '/':
                    n = stack.pop()
                    if n >= 0:
                        stack.append(n // num)
                    else:
                        stack.append(-(abs(n) // num))
                lastsign = char
                num = 0

        # iterate over stack and add all the values
        ans = 0
        for num in stack:
            ans += num
        return ans