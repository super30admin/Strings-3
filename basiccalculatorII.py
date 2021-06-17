"""227. Basic Calculator II
Time Complexity : O(n)
Space Complexity: O(n)"""
class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s)==0:
            return 0
        s=s.strip()
        stack =[]
        lastsign ='+'
        num =0
        
        for i in range(len(s)):
                
            ch = s[i]
            if ch == ' ':
                continue
            
            #if encounter a number
            if ch.isdigit():
                num = num*10 + int(ch)
                #if encounter a sign
            if not (ch.isdigit()) or i == len(s)-1:
                if lastsign =='+':
                    stack.append(num*1)
                elif lastsign =='-':
                    stack.append(-1*num)
                elif lastsign =='*':
                    stack.append(stack.pop()*num)
                elif lastsign =='/':
                    stack.append(int(stack.pop()/num))
                #print(stack)
                lastsign = ch
                num =0
        result = 0
        while stack:
            result +=stack.pop()
        return result
                    
            
                