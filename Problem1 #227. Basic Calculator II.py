# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def calculate(self, s: str) -> int:
        # base
        if len(s) == 0:
            return 0

        # logic
        s = s.trim()
        lastSign = '+'
        num = 0
        calc = 0
        tail = 0
        

        for i in range(len(s)):
            if s[i].isdigit:
                num = num * 10 + s[i] - '0'
            else:
                if lastSign == "+":
                    calc = calc + num
                    tail = +num
                elif lastSign == '-':
                    calc = calc - num
                    tail = -num
                elif lastSign == "*":
                    calc = calc - tail + tail * num
                    tail = tail * num
                else:
                    calc = calc - tail + tail / num
                    tail = tail / num
                
                lastSign = s[i]
                num = 0
        
        return calc