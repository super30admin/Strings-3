class Solution:
    def calculate(self, s: str) -> int:
        
        """
        keyIdea
        expression : 13 + 2*2 -1
        + ---> calc+num
        - ---> calc-num
        * ----> calc-tail + tail*num
        / ----> calc-tail + tail/num
        
        
                    lastsign   tail.    calc      num
                       +        0        0         1
                       +        0        0         13
                       +.       13       13        0
                       +        13       13        2
                       +        2        15        0
                       *        2        15        2
                       -        4    15-2 + (2*2)  0
                       -        4        17        1
                              
        
        TC:O(len(s))
        """
        res=0
        num=0
        lastSign='+'
        calc=0
        tail=0
        
        for i in range(len(s)):
            ch=s[i]
            if ch.isdigit():
                num=num*10 + int(ch)
                # print(num)
            if(not ch.isdigit() and ch!=" ") or i==len(s)-1:
                if lastSign=='+':
                    calc=calc+num
                    tail=num
                elif lastSign=='-':
                    calc=calc-num
                    tail=-num
                elif lastSign=='*':
                    calc=calc-tail+(tail*num)
                    tail=tail*num
                    
                else:
                    calc=calc-tail+(tail//num)
                    tail=tail//num
                
                lastSign=ch    
                num=0
                
                
    
        return calc
        
        
            
            
            
        