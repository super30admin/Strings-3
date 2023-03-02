# Time Complexity : O(N)
# Space Complexity : O(1)

class Solution:
    def calculate(self, s: str) -> int:
        calc = 0
        curr = 0
        tail = 0
        lastSign = '+'
        s = s.strip()
        for i in range(len(s)):
            num = s[i]
            if num.isdigit():
                curr = curr*10 + int(num)

            if ((not num.isdigit() or i == len(s) - 1) and num != ' '):
                if lastSign == '+':
                    calc = calc + curr
                    tail = curr
                elif lastSign == '-':
                    calc = calc - curr
                    tail = -curr
                elif lastSign == '*':
                    calc = calc - tail + (tail * curr)
                    tail = tail * curr
                else:
                    1 + 3/2
                    calc = calc - tail + int(tail / curr)
                    tail = int(tail / curr)

                lastSign = num
                curr = 0

        return calc
