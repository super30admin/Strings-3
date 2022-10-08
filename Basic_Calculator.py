'''
Time Complexity - O(n)
Space Complexity - O(1)
'''


class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        lastSign = '+'
        curr = 0
        tail = 0
        calc = 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                curr = curr*10 + int(c)

            if (not c.isdigit() and c != ' ') or (i == len(s)-1):
                if lastSign == "+":
                    calc = calc + curr
                    tail = +curr
                elif lastSign == "-":
                    calc = calc - curr
                    tail = -curr
                elif lastSign == "*":
                    calc = (calc - tail) + (tail*curr)
                    tail = tail*curr
                elif lastSign == "/":
                    calc = (calc - tail) + (tail/curr)
                    tail = tail/curr
                lastSign = c
                curr = 0
        return calc
