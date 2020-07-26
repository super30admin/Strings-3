'''
Solution:
1.  If a digit is occurred, add the value to the current value.
2.  If an operator is found, push the current value to the stack and refresh the current value.
3.  At the end, add all values in the stack.

Time Complexity:    O(n)    | Space Complexity: O(n)

--- Passed all testcases successfully on Leetcode
'''


class Calculator:
    def calculate(self, s: str) -> int:
        
        #   edge case check
        if (s == None or len(s) == 0):
            return 0
        
        #   initializations
        digits = '0123456789'
        operators = '+-*/'
        
        stack = []
        cursor = 0
        sign = '+'
        value = 0
        
        #   iterate until the cursor doesn't cross the length of the dtring
        while (cursor < len(s)):
            
            #   if value occurred
            if (s[cursor] in digits):
                value = (value * 10) + int(s[cursor])
            
            #   if operator occurred or is the last element in the string
            if ( (s[cursor] in operators) or cursor == len(s)-1):
                
                #   if sign is + or -, add the value to the stack with the sign
                if (sign == '+'):
                    stack.append(value)
                    value = 0
                elif (sign == '-'):
                    stack.append(-value)
                    value = 0
                #   if * or /, pop the top value, perform computation with the current value
                #   and push the result to the stack
                elif (sign == '*'):
                    tempValue = stack.pop()
                    stack.append(tempValue * value)
                    value = 0
                elif (sign == '/'):
                    tempValue = stack.pop()
                    stack.append(int(tempValue / value))
                    value = 0
                
                #   update the sign
                sign = s[cursor]
            
            cursor += 1
        
        result = 0

        #   add all elements present inside the stack
        while (len(stack) > 0):
            result += (stack.pop())
        
        #   return the result
        return result