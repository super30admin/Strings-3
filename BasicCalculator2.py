class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        lastSign = '+'
        curr = 0
        calc = 0
        tail = 0

        for i in range(0,len(s)):
            c = s[i]
            if c.isdigit():
                curr = curr *10+int(c)-int('0')
            if (not c.isdigit() and c!= ' ') or i == len(s)-1:
                if lastSign == '+':
                    calc = calc+curr
                    tail = curr
                elif lastSign == '-':
                    calc = calc - curr
                    tail = -curr
                elif lastSign == '*':
                    calc = calc-tail+(tail*curr)
                    tail = tail * curr
                else:
                    calc = calc - tail +int(tail/curr)
                    tail = int(tail/curr)
                lastSign = c
                curr = 0
        return calc
        


        