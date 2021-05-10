class Solution:
    def calculate(self, s: str) -> int:
        if not s:
            return 0
        
        stack = []        
        num = 0
        lastsign = "+"       
        
        for i in range(len(s)):
            #print(stack)
            if s[i].isdigit():
                num = num*10 + int(s[i])
            if s[i] in "+-*/" or (i == len(s)-1):
                
                if lastsign == "+":
                    stack.append(num)
                
                elif lastsign == "-":
                    stack.append(-num)
                
                elif lastsign == "*":
                    stack.append(stack.pop()*num)
                
                else:
                    stack.append(int(stack.pop() / num))
                num = 0
                lastsign = s[i]
               
        return sum(stack)
