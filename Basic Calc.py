class Solution:
    def calculate(self, s: str) -> int:
        
        
        i = 0
        num = 0
        s+="+"
        stack = []
        lastSign = "+"
        signs = ["+", "-", "*", "/"]
        while i<len(s):
            if s[i].isdigit():
                num = num*10 + int(s[i])
            elif s[i] in signs:                
                if lastSign == "+":
                    stack.append(num)
                elif lastSign == "-":
                    stack.append(-num)
                elif lastSign =="/":
                    curr = stack.pop()
                    stack.append(int(curr/num))
      
                elif lastSign =="*":
                    curr = stack.pop()
                    stack.append(curr*num)
                lastSign = s[i]
                num = 0
            i+=1
        return sum(stack)
