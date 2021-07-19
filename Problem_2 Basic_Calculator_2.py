# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# Multiplication and Division have Same Precedence
# Addition and Subtraction have same precedence
class Solution:
    def calculate(self, s: str) -> int:
        result = 0
        stack = []
        last_sign = '+'
        num = 0

        if s == None or len(s) == 0:
            return 0

        for i in range(len(s)):

            if s[i].isdigit():
                num = num * 10 + int(s[i])
            #if its a sign, then process the earlier one
            if s[i] != " " and not s[i].isnumeric() or i == len(s) - 1:
                if last_sign == '+':
                    stack.append(num)    #push the num to stack
                elif last_sign == '-':
                    stack.append(-num)
                elif last_sign == '*':
                    stack.append(int(stack.pop() * num))
                elif last_sign == '/':
                    stack.append(int(stack.pop() / num))

                last_sign = s[i]
                num = 0
        #Add all the values in the stack
        while stack:
            result += stack.pop()
        return int(result)