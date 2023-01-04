"""
FAANMG Problem #101 {Hard} 

227. Basic Calculator II

Time Complexity O(N)
Space Complexity:  O(1)
        
Did this code successfully run on Leetcode : Yes



@name: Rahul Govindkumar_RN27JUL2022
"""
class Solution:
    def calculate(self, s: str) -> int:
        
        if len(s)==0:
            return 0
        
        operator = '+'
        
        curr =0
        calc = 0
        tail = 0
        i =0
        
        while i < len(s):
            char = s[i]
            
            if char == ' ':
                i+=1
                continue
   
         
            # find the number before any operator
            if char.isdigit():
                while i < len(s) and s[i].isdigit():
                    curr = curr * 10 + ( ord(s[i]) - ord('0'))
                    i += 1
                i -= 1
                
      
         
        
                if operator =='+':
                    calc = calc + curr
                    tail = curr
                   
                elif operator =='-':
                    calc = calc - curr
                    tail = -curr
                    
                elif operator =='*':
                    calc = calc - tail + ( curr * tail )
                    tail = tail * curr
                    
                elif operator =='/':
                    
                    #IMP note: -3/2 gives 2 not 1
                    calc = calc - tail + int( tail / curr   )
                    tail = int(tail / curr)
                    
                curr = 0
            else:
                operator = char
                print(char)
               
            i +=1
            
                
        return calc
            
            
            

"""
FAANMG Problem #101 {Hard} 

227. Basic Calculator II

# TC - O(N) where s is len of string
# SC - O(N)
        
Did this code successfully run on Leetcode : Yes

Stack Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def calculate(self, s: str) -> int:
        
        if len(s)==0:
            return 0

        # maintain a stack to evaluate the expression
        stack = []
        
        # operator will be used to maintain the last sign encountered to evaluate when a new sign is there
        operator = '+'        
        curr = 0
        calc = 0
        tail = 0
        res = 0
        
        i=0
        while i < len(s):
            char = s[i]
            
 
         
            # find the number before any operator
            if char.isdigit():

                curr = curr * 10 + ( ord(s[i]) - ord('0'))

            # if the ch is not a digit and space or end of the string
            if (not char.isdigit() and char != ' ') or i == len(s) - 1:
                
                # if + sign, then simply add the +num to the stack
                if operator =='+':
                    stack.append(curr)
                
                # if - sign, then simply add the -num to the stack                   
                elif operator =='-':
                    stack.append(-curr)
                
                # if we have *, then we pop the last element from the stack, evaluate it with curr num
                # and then store it to the stack                    
                elif operator =='*':
                    temp = stack.pop() 
                    stack.append(curr * temp)
                
                # if we have /, then we pop the last element from the stack, evaluate it with curr num
                # and then store it to the stack     
                elif operator =='/':
                    
                    #IMP note: -3/2 gives 2 not 1

                    temp = stack.pop()
                    stack.append(int(temp/curr))

                    
                curr = 0
                operator = char
            i +=1
        # at the end, we just pop the elements from the stack and evaluate it to the result and return it
        while stack:
            res += stack.pop()
            
                
        return res
            
            
            
        