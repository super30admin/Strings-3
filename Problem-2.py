class Solution:
    def calculate(self, s: str):
        num=0
        sign='+'
        i=0
        temp=int
        output=0
        stack=[]
        while(i<len(s)):
            ch=s[i]
            if ch.isdigit():
                num=num*10 + int(ch)
                
            if (not ch.isdigit() and ch!=' ') or i==len(s)-1:
                if sign=='+':
                    stack.append(num)
                elif sign=='-':
                    stack.append(num*-1)
                elif sign=='*':
                    temp=stack.pop()
                    stack.append(temp*num)
                elif sign=='/':
                    temp=stack.pop()
                    if temp>=0:
                        stack.append(temp//num)
                    else:
                        stack.append((abs(temp)//num) *-1)                
                sign=ch
                num=0
            i+=1
        
        while len(stack)>0:
            output+=stack.pop()
            
        return output
            
        