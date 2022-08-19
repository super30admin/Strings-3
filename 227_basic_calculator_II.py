'''
## Problem 227: Basic calculator II

## Author: Neha Doiphode
## Date:   08-16-2022

## Description:
    Given a string s which represents an expression, evaluate this expression and return its value.
    The integer division should truncate toward zero.
    You may assume that the given expression is always valid.
    All intermediate results will be in the range of [-231, 231 - 1].

    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

## Examples:
    Example 1:
        Input: s = "3+2*2"
        Output: 7

    Example 2:
        Input: s = " 3/2 "
        Output: 1

    Example 3:
        Input: s = " 3+5 / 2 "
        Output: 5

## Constraints:
    1 <= s.length <= 3 * 105
    s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    s represents a valid expression.
    All the integers in the expression are non-negative integers in the range [0, 231 - 1].
    The answer is guaranteed to fit in a 32-bit integer.

## Time complexity: O(n), where n is length of the string, we are traversing over the input string once.

## Space complexity: O(1), no auxiliary space is used.

'''

def get_input():
    print("Enter the input expression: ", end = "")
    string = input()
    print()
    return string

class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0:
            return 0

        s = s.strip()

        last_sign = '+'
        num = 0
        calc = 0
        tail = 0

        for i in range(len(s)):
            if s[i].isdigit():
                num = 10 * num + int(s[i])

            if (s[i].isdigit() == False and s[i] != " ") or i == len(s) - 1:
                if last_sign == '+':
                    calc += num
                    tail = num

                elif last_sign == '-':
                    calc -= num
                    tail = -num

                elif last_sign == '*':
                    calc = (calc - tail) + (tail * num)
                    tail = tail * num

                elif last_sign == '/':
                    calc = (calc - tail) + int(tail / num)
                    tail = int(tail / num)

                num = 0
                last_sign = s[i]

        return calc

    def calculate_using_stack(self, s: str) -> int:
        '''
        Time complexity : O(n), where n is length of the list, we traverse the string once.
        Space complexity: O(m), where m is number of operands, as we use auxiliary stack to store intermediary results.
        '''
        if len(s) == 0:
            return 0

        s = s.strip()

        last_sign = '+'
        num = 0
        calc = 0

        stack = []
        for i in range(len(s)):
            if s[i].isdigit():
                num = 10 * num + int(s[i])

            if (s[i].isdigit() == False and s[i] != " ") or i == len(s) - 1:
                if last_sign == '+':
                    stack.append(num)
                elif last_sign == '-':
                    stack.append(-num)
                elif last_sign == '*':
                    top = stack.pop()
                    stack.append(top * num)
                elif last_sign == "/":
                    top = stack.pop()
                    stack.append(int(top / num))
                num = 0
                last_sign = s[i]

        while len(stack) != 0:
            calc += stack.pop()

        return calc


# Driver code
solution = Solution()
string = get_input()
print(f"Input expression: {string}")
print(f"Approach 1: Using string traversal: Evaluated expression: {solution.calculate(string)}")
print(f"Approach 2: Using stack:            Evaluated expression: {solution.calculate_using_stack(string)}")
