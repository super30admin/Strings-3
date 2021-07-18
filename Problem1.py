# Time Complexity : O()
# Space Complexity : O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#add 0 + string in front of every string to get clarity

# tail will be having the previous mess created
# so when we encounter * or / we will nullify the previous mess and apply the present * or /
class Solution:
    def calculate(self, s: str) -> int:
        
        if s == None or s == "":
            return 0
        
        s = s.strip()
        
        num = 0
        lastSign = "+"
        calc = 0
        tail = 0
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isnumeric():
                num = 10*num + int(c)
            
            if c != " " and (c.isnumeric() == False or i == len(s) - 1):
                if lastSign == "+":
                    calc += num
                    tail = num
                if lastSign == "-":
                    calc -= num
                    tail = -num
                if lastSign == "*":
                    calc = calc - tail + (tail*num)
                    tail = num*tail
                if lastSign == "/":
                    if tail < 0:
                        calc = calc - tail + -1 * ((-1 * tail)//num)
                        tail = -1 * ((-1 * tail)//num)
                    else:
                        calc = calc - tail + int(tail//num)
                        tail = tail//num                
                lastSign = c
                num = 0
            
        return calc
        