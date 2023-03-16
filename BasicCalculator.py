#All TC passed on leetcode


class Solution:
    def calculate(self, s: str) -> int:


        # We traverse s with one char at a time, if its digit then we form num and store in cur, if its sign then we calculate the expression and store the calc and prev num with sign in tail.
        #Time complexity - O(n) - n is length of string
        #Space complexity - O(1)
        calc = 0
        cur = 0
        tail = 0
        lastsign = "+"

        s = s.strip()

        i=0
        while i<len(s):
            if s[i].isdigit():
                cur = cur*10 + (ord(s[i])-ord('0'))
            
            if s[i]!=" " and (not s[i].isdigit() or i==len(s)-1):
                if lastsign == "+":
                    calc = calc + cur
                    tail = cur

                elif lastsign=="-":
                    calc = calc - cur
                    tail = -cur

                elif lastsign == "*":
                    calc = calc - tail + tail * cur
                    tail = tail*cur

                elif lastsign == "/":
                    calc = int (calc - tail) + int(tail / cur)
                    tail = int (tail/cur)
                
                lastsign = s[i]
                cur = 0
            
            i+=1

        return calc


#---------------------------------------------OR--------------------------------------------------

        #Here we push each num into stack along with sign. We traverse s with one char at a time, if its digit then we form num and store in cur, if its sign then we push cur num and sign into stack. If the signs are * and / then we evaluate the cur num and sign along with top num and sign in stack.
        #Time complexity - O(n) - n is length of string
        #Space complexity - O(1)
        stack = []

        lastsign = "+"
        cur = 0
        s = s.strip()

        i=0
        while i<len(s):
            if s[i].isdigit():
                cur = cur*10 + (ord(s[i])-ord('0'))
                
            if s[i]!=" " and (not s[i].isdigit() or i==len(s)-1):
                if lastsign=="+":
                    stack.append(+cur)
                    cur=0
                    lastsign=s[i]
                    

                elif lastsign=="-":
                    stack.append(-cur)
                    cur=0
                    lastsign=s[i]
                    

                elif lastsign=="*":
                    val = stack.pop()
                    stack.append(val * cur)
                    cur = 0
                    lastsign = s[i]
                    

                elif lastsign=="/":
                    val = stack.pop()
                    stack.append(int(val / cur))
                    cur = 0
                    lastsign = s[i]
                
            
            i+=1
        
        res = 0
        while stack:
            res = res + stack.pop()

        return res

            