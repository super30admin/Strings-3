"""
Time : 0(N)
Space : 0(N) -> Worst case size of stack
Leetcode: yes
Explanation : Maintain a stack of elements and add numbers based on the sign seen before it. Sum the stack at the end.
"""
class Solution:
    def calculate(self, s: str) -> int:

        num, stack, sign = 0, [], "+"
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if s[i] in "+-*/" or i == len(s) - 1:
                if sign == "+":
                    stack.append(num)
                elif sign == "-":
                    stack.append(-num)
                elif sign == "*":
                    stack.append(stack.pop()*num)
                else:
                    stack.append(int(stack.pop()/num))
                num = 0
                sign = s[i]
        return sum(stack)