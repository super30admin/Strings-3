class Solution:
    def calculate(self, s: str) -> int:
        #TC O(n)
        #SC O(1)
        if s is None or len(s) == 0:
            return 0
        num =0
        lastSign = "+"
        calc = 0
        tail =0 
        num = 0
        s = s.strip()
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 +  ord(s[i]) -  ord('0')
            if (not(s[i].isdigit() )and s[i] != " " ) or (i == len(s) -1):
                if lastSign == "+":
                    calc = calc + num
                    tail = num
                elif lastSign == "-":
                    calc = calc - num
                    tail = -num
                elif lastSign == "*":
                    calc = calc - tail + tail * num
                    tail = tail * num
                # /
                else:
                    calc = calc - tail + int(tail / num)
                    tail = int(tail / num)
                    
                # Update last sign and reset num
                lastSign = s[i]
                num = 0
        return calc
                
        
