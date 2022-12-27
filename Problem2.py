#2 + 3 / 5 + 2
# num = 2, calc = 0, tail = 0, lastSign = '+'
# char = '+', calc = 0 + 2, tail = 2, lastSign = '+'
# char = 3, lastSign = +, num = 3, calc = 2
# char = /, lastSign = +, calc = 3 + 2, tail = 3
# char = 5, tail = 3, num = 5
# char = +, lastSign = /, (calc - tail) 2 + (3//5) = 2 + 0

#Time complexity: O(n) where n is length of the string
#Space complexity: O(1)

#Accepted on Leetcode

#Approach:
#Use a calculating approach similar to backtracking in problem expression build operators -> maintain a calc, a current number, a tail and a last sign
#Whenever a digit is found keep adding it to current digit by place value (curNum * 10 + digit)
#Whenever a new operator is found, perform calculation of old operator(lastSign) (if + or -, simply add digit to calc, else use 'tail' to create new calc value) -> Set new num = 0, lastSign, tail values and continue -> Handle edge case of last digit where we must compute final calc value on last digit

#Alternate approach -> Using stack TC: O(n) SC: O(n )

class Solution:
    def calculate(self, s: str) -> int:
        calc = 0
        num = 0
        tail = 0 
        lastSign = '+'

        for i,char in enumerate(s):
            if char.isdigit(): #digit
                num = num * 10 + int(char)
            if (not char.isdigit() and char != ' ') or (i == len(s) - 1): #operator or last char
                if lastSign == '+':
                    calc = calc + num
                    tail = num
                elif lastSign == '-':
                    calc = calc - num
                    tail = -num
                elif lastSign == '*':
                    calc = (calc - tail) + (tail * num)
                    tail = tail * num
                elif lastSign == '/':
                    calc = (calc - tail) + int((tail / num))
                    tail = int(tail / num)
                lastSign = char
                num = 0

        return calc