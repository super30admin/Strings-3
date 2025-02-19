class Solution:
    # TC : O(n)
    # SC : O(1)
    def calculate(self, s: str) -> int:
        if s is None:
            return 0
        calc,tail,num = 0,0,0
        lastsign = "+"
        for i in range(len(s)):
            c = s[i]
            print(c,num,calc,tail,lastsign)
            if c.isdigit():
                num = num*10+(ord(c)-ord('0'))
            if (not c.isdigit() and c !=" ") or i == len(s)-1:
                if lastsign == "+":
                    calc = calc + num
                    tail = +num
                elif lastsign == "-":
                    calc = calc - num
                    tail = -num
                elif lastsign == "*":
                    calc = calc - tail + (tail*num)
                    tail = tail*num
                elif lastsign == "/":
                    
                    calc = calc - tail + int(tail/num)
                    tail = int(tail / num) 
                lastsign = c
                num = 0 
        return calc
             
            