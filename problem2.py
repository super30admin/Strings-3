#Time : O(n)
#Space : O(n)
class Solution:
    def calculate(self, s: str) -> int:
        stack = list()
        ops = ['/', '*', '+', '-']
        
        lastSign = '+'
        num = 0
        
        for i in range(len(s)):
            if s[i].isdigit():
                num = num*10 + int(s[i])
            
            if s[i] in ops or i == len(s) - 1:
                if lastSign == '+':
                    stack.append(num)
                elif lastSign == '-':
                    stack.append(-num)
                elif lastSign == '*':
                    stack.append(stack.pop()*num)
                elif lastSign == '/':
                    stack.append(int(stack.pop()/num))
                
                num = 0
                lastSign = s[i]
        
        return sum(stack)