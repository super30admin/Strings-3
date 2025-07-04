# Time complexity - o(n)
# Space complexity - o(1)

class Solution:
    def calculate(self, s: str) -> int:

        s = s.replace(" ", "") + '+'

        calc = 0
        tail = 0
        
        lastExp = '+'

        curr = 0
        for c in s:
            if c.isdigit():
                curr= curr*10 + int(c)
            else:
                if lastExp == '+':
                    calc = calc+curr
                    tail = curr
                elif lastExp == '-':
                    calc = calc-curr
                    tail = -curr

                elif lastExp == '*':
                    calc = calc-tail+tail*curr
                    tail = tail*curr

                elif lastExp == '/':
                    calc = calc-tail+int(tail / curr)
                    tail = int(tail / curr)

                curr = 0
                lastExp = c

        return calc
            


        