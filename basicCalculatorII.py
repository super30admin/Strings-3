#Time Complexity : O(n) where n is the length of the input string
#Space Complexity : O(n) where n is the length of the input string
#Did this code successfully run on Leetcode : Yes

class Solution:
    def calc(self, num, operation, stack):
        if operation == "+":
            stack.append(num)
        elif operation == "-":
            stack.append(-num)
        elif operation == "*":
            curr = stack.pop()
            stack.append(curr*num)
        else:
            curr = stack.pop()
            if curr//num < 0 and curr%num != 0:
                    stack.append(curr//num+1)
            else:
                stack.append(curr//num)


    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0
        stack = []
        num = 0
        operation = "+"
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num*10 + int(char)
            if (not char.isdigit() and char != " ") or i == len(s)-1:
                self.calc(num, operation, stack)
                num = 0
                operation = char
        result = 0
        while stack:
            result += stack.pop()

        return result
