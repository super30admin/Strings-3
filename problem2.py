#Time Complexity: O(n)
#Space : O(1)

class Solution:
    def calculate(self, s: str) -> int:
        calc = 0
        num = 0
        tail = 0
        sign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                num = num*10+int(s[i])
            if ((not s[i].isdigit() and s[i]!=" ") or i==len(s)-1):
                if sign == '+':
                    calc = calc + num
                    tail = num
                elif sign == '-':
                    calc = calc - num
                    tail = -num
                elif sign=='*':
                    calc = calc - tail + tail *num
                    tail = tail * num
                elif sign=='/':
                    calc = calc - tail + int((tail /num))
                    tail = int(tail / num)
                sign = s[i]
                num = 0
        return calc
