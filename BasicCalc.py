class Solution:
    def calculate(self, s: str) -> int:
        
        if not s:
            return 0
        
        s = s.replace(' ','')
        print(s)
        
        num = 0
        lastSign = '+'
        stack = []
        result = 0
        
        for i in range(len(s)):
            
            if s[i].isdigit():
                num = num*10+int(s[i])
            
            if (not s[i].isdigit()) or i == len(s)-1:
                    
                    if lastSign == '+':
                        stack.append(num)

                    if lastSign == '-':
                        stack.append(-num)

                    if lastSign == '*':
                        stack.append(stack.pop()*(num))
                        
                    if lastSign == '/':

                        val = stack.pop()
                        if val < 0:
                            stack.append(-(-val//(num)))
                        else:
                            stack.append(val//(num))

                    num = 0
                    lastSign = s[i]
                
        for val in stack:
            result = result + val
            
        return result
