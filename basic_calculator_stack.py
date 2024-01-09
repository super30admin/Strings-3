"""
Time Complexity: O(n) where n is the length of the string
Space Complexity: O(n) where n is the stack space

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Append the numbers to the stack whenever the input character is operator
For Addition and subtraction only append the numbers
For multiplication and division pop the top element in the stack and multiply or divide by the currnum
At the end add all the remaing elements in the stack 
"""


class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0

        currNum = 0
        lastOperator = "+"
        stack = []
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                currNum = currNum * 10 + ord(char) - ord("0")
            if not char.isdigit() and char != " " or i == len(s)-1:
                if lastOperator == "+":
                    stack.append(currNum)
                elif lastOperator == "-":
                    stack.append(currNum*-1)
                elif lastOperator == "*":
                    stack.append(stack.pop() * currNum)
                elif lastOperator == "/":
                    stack.append(int(stack.pop() / currNum))
                currNum = 0
                lastOperator = char
        result = 0
        while len(stack) > 0:
            result += stack.pop()
        return result
