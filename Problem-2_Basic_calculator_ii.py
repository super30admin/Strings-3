# APPROACH  
# Time Complexity : O(s), s: len(s)
# Space Complexity : O(s)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. if char is int, save it to curr_num (maintain 42 and not 4 and 2)
# 2. if char is sign -> check if the last sign is / or * -> pop from stack and apply the op on it with the curr_num
#                    -> if last sign is + or -, push the curr_num to stack along with it's sign
# 3. if char is space -> IGNORE
# 4. if the last char, push to stack along with the sign (+ or -)
# 5. at end, sum all elements of stack -> result

class Solution:
    def calculate(self, s: str) -> int:
        
        if s is None:
            return None
        
        stack, curr_num, last_sign = [], 0, '+'
        
        for ind in range(len(s)):
            
            if ord(s[ind]) >= ord('0') and ord(s[ind]) <= ord('9'):
                curr_num = curr_num * 10 + (ord(s[ind]) - ord('0'))
        
            if ((ord(s[ind]) < ord('0') or ord(s[ind]) > ord('9')) and s[ind] != ' ') or ind == len(s) - 1:
                
                if last_sign == '/':
                    popped, flag = stack.pop(), False
                    if popped < 0: flag = True
                    res = abs(popped) // curr_num
                    if flag: stack.append(-1 * res)
                    else: stack.append(res)
                        
                elif last_sign == '*': stack.append(stack.pop() * curr_num)
                elif last_sign == '+': stack.append(curr_num)
                elif last_sign == '-': stack.append(-1 * curr_num)
                    
                curr_num = 0
                last_sign = s[ind]
                
        result = 0
        while stack:
            result += stack.pop()
            
        return result
