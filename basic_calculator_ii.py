class Solution:
    def calculate(self, s: str) -> int:
        
        last_sign = '+'
        calc = 0
        num = 0
        tail = 0

        for i in range(len(s)):
            if s[i].isdigit():
                
                num = num*10 + int(s[i])
            
            if (not s[i].isdigit() and s[i]!= " ") or (i == len(s) - 1):
                if last_sign == '+':
                    calc += num
                    tail = num
                elif last_sign == '-':
                    calc -= num
                    tail = -num
                elif last_sign == '*':
                    calc = (calc - tail) + (tail * num)
                    tail = tail * num
                elif last_sign == '/':
                    calc = (calc - tail) + math.trunc((tail / num))
                    tail = math.trunc((tail / num))
                
                last_sign = s[i]
                num = 0
                
        return calc