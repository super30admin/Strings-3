class Solution:
    def calculate(self, s: str) -> int:
        curr = 0
        tail = 0
        last = "+"
        calc = 0
        for idx,i in enumerate(s):
            
            if(i.isdigit()):
                curr = curr*10 + int(i)
            if((i!=" " and not i.isdigit()) or idx==len(s)-1) :
                if(last=="+"):
                    calc += curr
                    tail = curr
                elif(last=="-"):
                    calc = calc-curr
                    tail = -curr
                elif(last=="*"):
                    calc= (calc-tail) + tail*curr
                    tail = tail*curr
                else:
                    if(tail<0):
                        calc= (calc-tail) - (-tail//curr)
                        tail = -(-tail//curr)
                    else:
                        calc= (calc-tail) + tail//curr
                        tail = tail//curr
                    
                    
                curr = 0
                last = i
            
        return calc