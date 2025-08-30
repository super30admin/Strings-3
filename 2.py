'''
Problem2

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)
'''

class Solution:
    def calculate(self, s: str) -> int:
        curr = 0
        lastSign = "+"
        calc = 0
        tail = 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                curr = curr * 10 + int(c)
            if(not c.isdigit()and c != " ") or (i == len(s) - 1):
                if lastSign == "+":
                    calc = calc + curr
                    tail = +curr
                if lastSign == "-":
                    calc = calc - curr
                    tail = -curr
                if lastSign == "*":
                    calc = calc-tail + tail*curr
                    tail = tail * curr
                if lastSign == '/':
                    calc = calc-tail + int(tail/curr)
                    tail = int(tail/curr)
                lastSign = c
                curr = 0
        return calc                     