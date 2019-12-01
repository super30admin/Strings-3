#Algo : With 1 stack add the numbers to it if the sign next to it is + or -, if the sign is * or / then calculate that with the previous element and update it...
#time - O(N)#space -O(N)
class Solution:
    def calculate(self, s: str) -> int:
        # declaring variables
        stack = []
        sign = '+'  # this is the last encountered sign variable in the string-- used to manipulate numbers eneters in to the stack
        num = 0
        # return variables
        sum = 0
        # edge cases
        if not (s):
            return 0
            # logic
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(
                    s[i])  # here we multiplu by num, that is incase its a part of non single digit number
            if not (s[i].isdigit()) and s[i] != " " or i == len(
                    s) - 1:  # case when we encounter an matematical operator
                if sign == '+':
                    stack.append(num)
                elif sign == '-':
                    stack.append(-num)  # we append numbers with -ve sign as we can driectly add these in the end
                elif sign == '*':
                    temp = stack.pop()  # temporary variable to calculate mulpitication and division
                    stack.append(temp * num)
                elif sign == '/':
                    temp = stack.pop()
                    if temp // num < 0 and temp % num != 0:  # this case when the number is negative and number not exactly divisible by the num
                        stack.append(int(temp // num + 1))
                    else:  # normal cases of mu  and division
                        stack.append(int(temp // num))
                sign = s[i]
                num = 0
        # returning
        while stack:
            sum += stack.pop()  # as stack has only the digits and they have to be added

        # return variables
        return sum