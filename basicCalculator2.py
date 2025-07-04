"""
Traverse the string to build numbers digit by digit
Push current number onto a stack based on the previous operator
   - '+' -  push number, '-' - push -number, '*' or '/' - compute with top of stack
Return the sum of stack 
"""
"""
Time Complexity - O(n) – One pass through string
Space Complexity - O(n) – Stack for intermediate results
"""

class basicCalculator2:
    def calculate(self, s: str) -> int:
        s = s.replace(" ", "") + "+"  
        stack = []
        num = 0
        sign = '+'

        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c in '+-*/':
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)
                elif sign == '*':
                    stack.append(stack.pop() * num)
                elif sign == '/':
                    stack.append(int(stack.pop() / num))

                sign = c
                num = 0

        return sum(stack)
    
if __name__ == "__main__":
    obj = basicCalculator2()
    print(obj.calculate("3+2*2"))        
    print(obj.calculate(" 3/2 "))        
    print(obj.calculate(" 3+5 / 2 "))    
