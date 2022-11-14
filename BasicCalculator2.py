class Solution:
    def calculate(self, s: str) -> int:
        
        
        # Using stack
        # 12 * 3/2 - 11 + 20 
        
        # "14-3/2" for division
        
        stack = []
        
        last_operator = "+"
        curr_num = 0
        
        for i in range(len(s)):
            
            if s[i].isdigit():
                curr_num = curr_num * 10 + int(s[i])
            
            if (not s[i].isdigit() and not s[i] == " ") or (i == len(s) - 1) :
                
                if last_operator == "+":
                    stack.append(curr_num)
                
                elif last_operator == "-":
                    stack.append(-curr_num)
                
                elif last_operator == "*":
                    stack.append(stack.pop() * curr_num)
                
                elif last_operator == "/":
                    
                    temp = stack.pop()
                    
                    if temp < 0:
                        stack.append(math.ceil(temp / curr_num))
                    else:
                        stack.append(math.floor(temp / curr_num))
                    
                curr_num = 0
                last_operator = s[i]
        
        return sum(stack)
    
    # Time Complexity: O(n) where n is th length of the string s
    # Space Complexity: O(n)
    
                
class Solution:
    def calculate(self, s: str) -> int:
        
        
        # without stack
        # 12 * 3/2 - 11 + 20 
        
        # "14-3/2" for division
        # Calc and tail concept is used in expression add operators
        
        
        last_operator = "+"
        curr_num = 0
        calc = 0
        tail = 0
        
        for i in range(len(s)):
            
            if s[i].isdigit():
                curr_num = curr_num * 10 + int(s[i])
            
            if (not s[i].isdigit() and not s[i] == " ") or (i == len(s) - 1) :
                
                if last_operator == "+":
                    calc = calc + curr_num
                    tail = curr_num
                
                elif last_operator == "-":
                    calc = calc - curr_num
                    tail = -curr_num
                
                elif last_operator == "*":
                    calc = calc - tail + tail * curr_num
                    tail = tail * curr_num
                
                elif last_operator == "/":
                    if tail < 0:
                        calc = calc - tail + math.ceil(tail/curr_num)
                        tail = math.ceil(tail/curr_num)
                    else:
                        calc = calc - tail + math.floor(tail/curr_num)
                        tail = math.floor(tail/curr_num)
                    
                curr_num = 0
                last_operator = s[i]
        
        return calc
    
    # Time Complexity: O(n) where n is th length of the string s
    # Space Complexity: O(1)