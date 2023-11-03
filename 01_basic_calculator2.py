#https://leetcode.com/problems/basic-calculator-ii
#TC: O(l) where l is the length of string
#SC: O(1) since we are not using any data structure

class Solution:
    def calculate(self, s: str) -> int:
        
        i = 0
        curr = prev = res = 0
        
        curr_op = '+'
        
        while i <len(s):
            
            curr_char = s[i]
            
            #parsing more than 1 digits eg 331, 11 etc
            if curr_char.isdigit():
                while i <len(s) and s[i].isdigit():
                    curr = curr*10 + int(s[i])
                    i += 1
            
                i -= 1 #to keep i at the digit eg 1 in 331
                
                if curr_op == '+':
                    res += curr
                    prev = curr
                
                elif curr_op == '-':
                    res -= curr
                    prev = -curr
                    
                elif curr_op == '*':
                    res -=prev #undo previous
                    res += prev*curr
                    prev = prev *curr
                    
                else:
                    res -=prev #undo previous
                    res += int(prev/curr)
                    prev = int(prev/curr)
                    
                curr = 0 #reset current
                
            #curr_char != " " ie it's an operation  
            elif curr_char != " ":
                curr_op = curr_char
                
            i+= 1
        return res