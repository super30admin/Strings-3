class Solution:
    
    """
    Description: Given a string s which represents an expression, evaluate this expression and return its value
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach: follow BODMAS rule by using stack
    1. create a function which takes current number and sign to add elements to the stack based on the sign
       - if sign is +ve or -ve, just add the item
       - if sign is "*" or "/", pop stack -> operate with current number and push back to the stack
    2. loop through the entire string, start with current number as 0 and current sign as "+":
       - if character is digit, multiply current number by 10 and add the character 
       - if character is anything else but not an empty string, use #1 to update the stack
    3. at the end we will be left with a number which is not in stack yet, for that use #1 again to update the stack
    4. add all the numbers in the stack to find the answer
    """
    
    def calculate(self, s: str) -> int:
        
        if s == None: return
       
        # start with
        sign = "+"; num = 0
        stack = []
        
        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            elif char != " ":
                stack = self.eval_stack(stack, num, sign)
                sign = char; num = 0
        
        stack = self.eval_stack(stack, num, sign)
        
        cSum = 0;
        for val in stack: cSum += val
            
        return cSum

    def eval_stack(self, stack, num, sign):
        if sign == "+": stack.append(num)
        elif sign == "-": stack.append(-num)
        elif sign == "*": stack.append(stack.pop()*num)
        else: stack.append(int(stack.pop()/num))
        return stack
