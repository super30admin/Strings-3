class Solution:
    def calculate(self, s: str) -> int:
        if s==None or len(s)==0:
            return 0
        s=s.strip(" ")
        lastSign='+'
        current=0
        tail=0
        calc=0
        
        for i in range(len(s)):
            # s[i]=int(s[i])
            if s[i].isdigit():
                current=current*10+int(s[i])
            if (not s[i].isdigit() or i==len(s)-1) and s[i]!=' ':
                
                if lastSign=='+':
                    calc=calc+current
                    tail=+current
                    
                elif lastSign=='-':
                    calc=calc-current
                    tail=-current
                    
                elif lastSign=='*':
                    calc=calc-tail+tail*current
                    tail=tail*current
                
                elif lastSign=='/':
                    calc=calc-tail+int(tail/current)
                    tail=int(tail/current)
  
                print(calc)
                lastSign=s[i]
                current=0
                             
        return calc
                
            
            
        