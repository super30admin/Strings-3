def calculate(self, s: str) -> int:
        
        """
        keyIdea
        expression : 13 + 2*2 -1
                    lastsign   num
                       +        0
                       +        1
                       +.       10*1+3
                       +        0
                       +        2
                       *        0
                       +        2
                       -        0
                       -        1
               stack = 13-->2*2=4---> -1
                       
        
        TC:O(len(s))
        SC: O(len(s))
        """
        res=0
        num=0
        lastSign='+'
        stack=[]
        
        for i in range(len(s)):
            ch=s[i]
            if ch.isdigit():
                num=num*10 + int(ch)
                # print(num)
            if(not ch.isdigit() and ch!=" ") or i==len(s)-1:
                if lastSign=='+':
                    stack.append(num)
                elif lastSign=='-':
                    stack.append(num*(-1))
                elif lastSign=='*':
                    # cur=int(stack.pop()*num)
                    stack.append(int(stack.pop()*num))
                elif lastSign == '/':
                    # cur=int(stack.pop()/num)
                    stack.append(int(stack.pop()/num))
                num=0
                lastSign=ch
                
        while stack:
            res=res+stack.pop()
        return res
        
        
            
            
            
        