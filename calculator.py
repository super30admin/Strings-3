# using stacks to store the number
# We will start by keeping a prev_sign and prev_num. As soon as we hit operators "+" or "-" next, push the prev_sign and prev_val to stack.
# If the next operators are "*" or "/", evaluate the previous number with the current number. * and / have higher precedence.
# once the string is traversed, pop the number from stack and sum them.

# time complexity - O(n)
# space complexity - O(n)
from collections import deque
class Solution:
    def calculate(self, s: str) -> int:
        prev_sign = "+"
        if s[0]=="-":
            prev_sign = "-"
            s=s[1:]
        prev_num = 0
        
        calculator_stack = deque()
        for i, ch in enumerate(s):
            if ch.isdigit():
                prev_num = prev_num*10 + int(ch)
            if (not ch.isdigit() and ch!=" ") or i==len(s)-1:
                if prev_sign == "-":
                    prev_num *= -1
                    calculator_stack.append(prev_num)
                    prev_num = 0
                elif prev_sign == "+":
                    calculator_stack.append(prev_num)
                    prev_num = 0
                elif prev_sign == "*":
                    calculator_stack.append(calculator_stack.pop() * prev_num)
                else:
                    calculator_stack.append(int(calculator_stack.pop() / prev_num))
                prev_sign = ch
                prev_num = 0
        
        eval_sum = 0
        while calculator_stack:
            eval_sum += calculator_stack.pop()
        
        return eval_sum