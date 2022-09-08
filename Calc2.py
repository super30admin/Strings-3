# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def calculate(self, s):
        if not s or len(s) == 0:
            return 0
        
        # maintain a stack to evaluate the expression
        stack = []
        calc = tail = curr = 0
        # sign will be used to maintain the last sign encountered to evaluate when a new sign is there
        sign = '+'
        res = 0
        for i in range(len(s)):
            ch = s[i]
            # find the number before any operator
            if ch.isdigit():
                curr = curr * 10 + ( ord(ch) - ord('0'))
            
            # if the ch is not a digit and space or end of the string
            if (not ch.isdigit() and ch != ' ') or i == len(s) - 1:
                # if + sign, then simply add the +num to the stack
                if sign == '+':
                    stack.append(curr)
                # if - sign, then simply add the -num to the stack
                elif sign == '-':
                    stack.append(-curr)
                # if we have *, then we pop the last element from the stack, evaluate it with curr num
                # and then store it to the stack
                elif sign == '*':
                    temp = stack.pop()
                    stack.append(curr * temp)
                else:
                # if we have /, then we pop the last element from the stack, evaluate it with curr num
                # and then store it to the stack 
                    temp = stack.pop()
                    stack.append(int(temp/curr))
                curr = 0
                sign = ch
        
        # at the end, we just pop the elements from the stack and evaluate it to the result and return it
        while stack:
            res += stack.pop()
        
        return res
