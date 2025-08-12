# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def calculate(self, s: str) -> int:
        currNum = 0
        lastSign = '+'
        tail = 0
        calc = 0

        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                currNum = currNum * 10 + int(c)

            if (not c.isdigit() and c != ' ') or i == len(s) - 1:
                if lastSign == '+':
                    calc = calc + currNum
                    tail = currNum
                elif lastSign == '-':
                    calc = calc - currNum
                    tail = -currNum
                elif lastSign == '*':
                    calc = (calc - tail) + (tail * currNum)
                    tail = tail * currNum
                elif lastSign == '/':
                    calc = (calc - tail) + int(tail / currNum)
                    tail = int(tail / currNum)

                currNum = 0
                lastSign = c
        return calc
