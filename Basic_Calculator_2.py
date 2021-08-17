#Time:O(n) to iterate through array
#Space:O(1)
class Solution:
    def calculate(self, s: str) -> int:
        s = ''.join(s.split())
        last_digit = False
        val = 0
        sign = "+"
        calc = 0
        tail = 0
        i=0
        while i<len(s):
            if s[i].isdigit():
                if last_digit:
                    val = val*10+int(s[i])
                else:
                    val = int(s[i])
                last_digit = True
            if not s[i].isdigit() or i == len(s)-1:
                last_digit = False
                if sign =="*":
                    calc = calc-tail + tail*val
                    tail = tail*val
                elif sign == "/":
                    calc = calc-tail + int(tail/val)
                    tail = int(tail/val)
                elif sign =="+":
                    calc = calc+val
                    tail = val
                else:
                    calc = calc-val
                    tail = -val
                sign = s[i]
            i+=1
        return calc
                