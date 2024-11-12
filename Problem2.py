# 227. Basic Calculator II

class Solution:
    def calculate(self, s: str) -> int:
        calc = 0
        currNum = 0
        tail = 0
        lastSign = '+'

        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                currNum = int(c) + (currNum * 10)
            
            # Process when hitting an operator OR at the last character    
            if (not c.isdigit() and c != ' ') or i == len(s) - 1:
                if lastSign == "+":
                    calc = currNum + calc
                    tail = currNum
                elif lastSign == "-":
                    calc = calc - currNum
                    tail = -currNum
                elif lastSign == "*":
                    calc = (calc - tail) + (tail * currNum)
                    tail = tail * currNum
                elif lastSign == '/':
                    calc = (calc - tail) + int(tail / currNum)
                    tail = int(tail / currNum)
                lastSign = c
                currNum = 0

        return calc
