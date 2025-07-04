class Solution:
    def calculate(self, s: str) -> int:
        s = s.replace(' ', '')
        result = 0
        tail = 0
        curr = 0
        lastSign = '+'
        i = 0
        
        while i < len(s):
            c = s[i]
            if c.isdigit():
                curr = curr * 10 + int(c)
            if not c.isdigit() or i == len(s) - 1:
                if lastSign == '+':
                    result += curr
                    tail = curr
                elif lastSign == '-':
                    result -= curr
                    tail = -curr
                elif lastSign == '*':
                    result -= tail
                    tail = tail * curr
                    result += tail
                elif lastSign == '/':
                    result -= tail
                    # Truncate toward zero
                    tail = int(tail / curr)
                    result += tail
                lastSign = c
                curr = 0
            i += 1
        
        return result






        