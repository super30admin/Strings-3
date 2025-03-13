# Problem 2 : Basic Calculator II
# Time Complexity : 
'''
With Stack- O(n) where n is the length of the s
Without Stack- O(n) where n is the length of the s
'''
# Space Complexity : 
'''
With stack- O(n) where n is the length of the s
Without stack- O(1)
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# with stack

class Solution:
    def calculate(self, s: str) -> int:
        # define stack for storing the numbers in the stack
        stack = []
        # variable to sote last sign in the expression
        lastSign = '+'
        # variable to store the current number
        currNum = 0
        # loop through expression
        for i in range(len(s)):
            # check if the character is a digit
            if s[i].isdigit():
                # if the character is digit then convert the character to a number
                # this is the current number
                currNum = currNum * 10 + int(s[i])
            # if the character is not digit and not space or the value i pointer is the lenght ie pointing to last element in expression
            if (not s[i].isdigit()) and s[i] != " " or i == len(s)-1:
                # if the last sign of the expression is '+'
                if lastSign == '+':
                    # append the current number to the stack
                    stack.append(currNum)
                # if the last sign of the expression is '-'
                if lastSign == '-':
                    # append the -current number to the stack
                    stack.append(-currNum)
                # if the last sign of the expression is '*'
                if lastSign == '*':
                    # first pop the top number, then multiply the number to current number and then append the result to stack
                    stack.append(stack.pop() * currNum)
                # if the last sign of the expression is '/'
                if lastSign == '/':
                    # first pop the top number, then divide the number by current number and then append the result to stack
                    stack.append(int(stack.pop() / currNum))
                # set the lastSign variable with current sign for future processing
                lastSign = s[i]
                # set the current number variable to 0
                currNum = 0
        # define result to 0 which will sotre the evaluated value
        result = 0
        # loop through stack until it is empty
        while (len(stack) > 0):
            # add the number from stack and store in result
            result = result + stack.pop()
        # return result
        return result



# without using stack
class Solution:
    def calculate(self, s: str) -> int:
        # define calculated value to 0
        calculatedValue = 0
        # define tail variable which will store the value of tail of the evaluated expression
        tail = 0
        # lenght of the expression 
        length = len(s)
        # define variable to store current number and last sign in the expression
        currNum = 0
        lastSign = '+'
        # loop through expression
        for i in range(length):
            # check if the character is a digit
            if(s[i].isdigit()):
                # if it is a digit then convert the character to number
                currNum = currNum * 10 + int(s[i])
            # check if the character is not digit and if it is not space or he value i pointer is the lenght ie pointing to last element in expression
            if((not s[i].isdigit() and s[i] != ' ') or i == len(s)-1):
                # if the last sign is '+'
                if(lastSign == '+'):
                   # the calculated value is sum of calculatedValue and currNum 
                   calculatedValue = calculatedValue + currNum
                   # tail is the currNum
                   tail = currNum
                # if the last sign is '-'
                elif(lastSign == '-'):
                    # the calculated value is difference between calculatedValue and currNum 
                   calculatedValue = calculatedValue - currNum
                   # tail is the -currNum
                   tail = -currNum
                # if the last sign is '*'
                elif(lastSign == '*'):
                   # the calculated value is calculatedValue - tail + (tail * currNum)
                   calculatedValue = calculatedValue - tail + tail * currNum
                   # tail is the tail * currNum
                   tail = tail * currNum
                # if the last sign is '*'
                elif(lastSign == '/'):
                   # the calculated value is calculatedValue - tail + (tail / currNum)
                   calculatedValue = calculatedValue - tail + int(tail / currNum)
                   # tail is the tail / currNum
                   tail = int(tail / currNum)
                # set the lastSign variable with current sign for future processing
                lastSign = s[i]
                # set the current number variable to 0
                currNum = 0
        # return the int of calculatedValue
        return int(calculatedValue)
        