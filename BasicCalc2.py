'''
    Time Complexity:
        O(n) (where n = length of the given string)

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Used Stack.
        -> Put only numbers in the stack in such a way that you have to only
            return the sum of your stack in the end.
        -> If your operator is:
            -> +, add the number to the stack as is.
            -> -, add the negation of the number to the stack.
            -> *, pop the top of the stack, multiply it with the current number,
                and push the new number on the stack.
            -> /, pop the top of the stack, divide it by the current number,
                and push the new number on the stack.
            After any of these steps, reset your current number in the test case.
'''

class Solution:
    def __init__(self):
        self.stack = []

    def calculate(self, s: str) -> int:
        num = 0
        optn = '+'

        for char in s:
            if char == ' ':
                continue

            if char.isdigit():
                num = num*10 + int(char)
            else:
                self.perform_operation(optn, num)
                num = 0
                optn = char

        self.perform_operation(optn, num)
        return sum(self.stack)

    def perform_operation(self, optn, num):
        if optn == '+':
            self.stack.append(num)

        elif optn == '-':
            self.stack.append(-num)

        elif optn == '*':
            self.stack.append(self.stack.pop() * num)

        elif optn == '/':
            self.stack.append(int(self.stack.pop() / num))
