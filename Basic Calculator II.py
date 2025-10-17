'''
Solution 1: Using tail 
    - maintain previous_sign, tail, calculated, current_num at each step.
    - Iterate over the expression, we have 3 cases:
        - digit:
            - update current_number by one decimal
        - " " (space):
            - ignore, continue 
        - signs: 
        do the computation from previous signs, update prev_sign to this sign and 
        reset current_num to zero. Prev_sign can be +,-,*,/
            - '+' :
                calculated = calculated + current_num
                tail = +current_num
            - '-' :
                calculated = calculated - current_num
                tail = -current_num
            - '*' :
                calculated = calculated - tail + (tail*current_num)
                tail = tail*current_num
            - '/' :
                calculated = calculated - tail + int(tail/current_num)
                tail = int(tail/current_num)
    - At the end, since last character would be either a space or digit, we need to
      do the final computation 

Time Complexity: O(N), N = len(string)
Space Complexity: O(1)
'''
class Solution:
    def calculate(self, s: str) -> int:
        current_num = 0
        prev_sign = '+'
        calculated = 0
        tail = 0
        for ch in s:
            if ch.isdigit():
                current_num = current_num*10 + int(ch)
            elif ch!=" ":
                if prev_sign == '+':
                    calculated+=current_num
                    tail = current_num
                elif prev_sign == '-':
                    calculated-=current_num
                    tail = -current_num
                elif prev_sign == '*':
                    calculated = calculated-tail + tail*current_num
                    tail = tail*current_num
                else:
                    calculated = calculated-tail + int(tail/current_num) # truncate to zero, requirement of problem
                    tail = int(tail/current_num)
                
                current_num = 0
                prev_sign = ch
        
        # Do final calculation at the end
        if prev_sign == '+':
            calculated+=current_num
            tail = current_num
        elif prev_sign == '-':
            calculated-=current_num
            tail = -current_num
        elif prev_sign == '*':
            calculated = calculated-tail + tail*current_num
            tail = tail*current_num
        else:
            calculated = calculated-tail + int(tail/current_num)
            tail = int(tail/current_num)
        

        return calculated
        