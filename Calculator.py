#TC: O(n)
#SC: O(n)

class Calculator:
    def calculate(self, s: str) -> int:
        
        if (s == None or len(s) == 0):
            return 0
        
        digits = '0123456789'
        operators = '+-*/'
        
        stack = []
        cursor = 0
        sign = '+'
        value = 0
        
        while (cursor < len(s)):
            
            if (s[cursor] in digits):
                value = (value * 10) + int(s[cursor])
            
            if ( (s[cursor] in operators) or cursor == len(s)-1):
                
                if (sign == '+'):
                    stack.append(value)
                    value = 0
                elif (sign == '-'):
                    stack.append(-value)
                    value = 0

                elif (sign == '*'):
                    tempValue = stack.pop()
                    stack.append(tempValue * value)
                    value = 0
                elif (sign == '/'):
                    tempValue = stack.pop()
                    stack.append(int(tempValue / value))
                    value = 0
                
                sign = s[cursor]
            
            cursor += 1
        
        result = 0

        while (len(stack) > 0):
            result += (stack.pop())
        
        return result