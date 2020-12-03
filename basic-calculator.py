# Time Complexity: O(N)
# Space Complexity: O(N)
# Approach: Use a stack to evaluate expressions. Traverse over the striong character by character. If the char is a number, accumulate subsequent digits to form a number. If the character is an operator, for +, - push the number with the respective sign on the stack. If the operator is *, / pop the last number, apply the operator and push the result back on the stack.
class Solution:
    def calculate(self, s):
        num, stack, sign = 0, [], "+"
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if not s[i].isdigit() or i == len(s) - 1:
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