# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I maintain last number and last sign. Everytime I encounter an operand, I either put the current number in stack of it is * or / I pop top element from
# stack do the operation and put the result on stack

class Solution:
    def calculate(self, s: str) -> int:
        stack = [] # 3 
        current_number = 0 # 3
        last_sign = "+" # 
        for symbol in s: # 3 + 
            if symbol == " ": continue
            if symbol.isnumeric(): 
                current_number = current_number * 10 + int(symbol)
            else:
                if last_sign == "*" or last_sign == "/":
                    left = stack.pop() # 
                    if last_sign == "*":
                        stack.append(int(left)*current_number) 
                    else:
                        stack.append(int(left)/current_number)
                else:
                    if last_sign == "-":
                        stack.append(-current_number)
                    else:
                        stack.append(current_number)
                last_sign = symbol
                current_number = 0
        if last_sign == "*" or last_sign == "/":
            left = stack.pop() # 
            if last_sign == "*":
                stack.append(int(left)*current_number) 
            else:
                stack.append(int(left)/current_number)
        else:
            if last_sign == "-":
                stack.append(-current_number)
            else:
                stack.append(current_number)
        last_sign = symbol
        current_number = 0
        result = 0

        for s in stack:
            result += int(s)
        return result
            
                
            
            
