class Solution:
    def calculate(self, s: str) -> int:
        num, ope, stack = 0, '+', []
        for cnt, i in enumerate(s):
            if i.isnumeric():
                num = num * 10 + int(i)
            if i in '+-*/' or cnt == len(s) - 1:
                if ope == '+':  # first time when the itr encounters a symbol it passes this and then updates it self after the if else ladder. 
                    stack.append(num)
                elif ope == '-':
                    stack.append(-num)
                elif ope == '*':
                    j = stack.pop() * num
                    stack.append(j)
                elif ope == '/':
                    j = int(stack.pop() / num)
                    stack.append(j)
            
                ope = i
                num = 0
       
        return sum(stack)

    
    
