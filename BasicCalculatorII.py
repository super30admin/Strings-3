'''
TC: O(n) - Iterating over the length of string
SC: O(1) - no space taken as we are using bunch of variables
'''
class Solution:
    def calculate(self, s: str) -> int:
        calc, curr, tail = 0,0,0
        lastSign = '+'
        for i,ch in enumerate(s):
            if ch.isdigit():
                curr = curr*10 + int(ch)
            if ((ch!=' ') and not ch.isdigit()) or i==len(s)-1:
                if lastSign == '+':
                    calc = calc+curr
                    tail = curr
                elif lastSign == '-':
                    calc = calc-curr
                    tail = -curr
                elif lastSign == '*':
                    calc = calc-tail + curr*tail
                    tail = curr*tail
                elif lastSign == '/':
                    calc = calc-tail + int(tail/curr)
                    tail = int(tail/curr)
                curr = 0
                lastSign = ch
        return calc
s = Solution()
print(s.calculate("3+2*2"))
print(s.calculate(" 3/2 "))
print(s.calculate(" 3+5 / 2 "))
print(s.calculate("0/1"))
print(s.calculate("14-3/2"))