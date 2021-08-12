class Solution:
    def calculate(self, s: str) -> int:
        #not required but still
        if s=="":
            return 0
        
        
        #stack solution
        stack=[]
        num=0
        lastsign="+"
        s=s.replace(" ","")
        s=s+"+"
        print(s)
        for c in s:
            #if c is digit just append to number
            if c.isdigit():
                num=num*10+ord(c)-ord('0')
            else:
                #c is not digit and one of +,-,*,/, we will perform last sign
                if lastsign=="+":
                    stack.append(num)
                elif lastsign=="-":
                    stack.append(-num)
                elif lastsign=="*":
                    stack.append(stack.pop()*num)
                elif lastsign=="/":
                    x=stack.pop()
                    v=floor(abs(x)/num)
                    
                    if x<0:
                        stack.append(-v)
                    else:
                        stack.append(v)
                lastsign=c
                num=0
        
        return sum(stack)
        #Time O(n)
        #Space O(n)
                
                
