# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We use three place holders to hold the numbers, One is the answer variable, where all the numbers go when we are sure that we won't 
need them again. The other two are the last_number variable and finally the num variable. when we encounter a sign in the for loop 
we need to decide what needs to be done for the previous numbers. If the sign is + or - we add the last_number to the answer and 
then update the last_number to the current num. If the sign is * or / we just update the last_number to the result of the operation. 
Finally we add the last_number to the answer and return the answer. The last number variable needs to carry the sign of the last number 
because in this way we won't miss out on the sign when doing operations between last_number and number.
"""

class Solution:
    def calculate(self, s: str) -> int:
        if s == None or len(s) == 0: return 0

        last_num = 0
        num = 0
        sign = '+'
        answer = 0

        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            elif char == ' ':
                continue
            elif not char.isdigit():
                if sign == '+':
                    answer = answer + last_num
                    last_num = num
                elif sign == '-':
                    answer = answer + last_num
                    last_num = -num
                elif sign == '*':
                    last_num = last_num * num
                else:
                    last_num = int(last_num / num)
                num = 0
                sign = char

        if sign == '+':
            last_num += num
        elif sign == '-':
            last_num -= num
        elif sign == '*':
            last_num *= num
        else:
            last_num = int(last_num / num)

        answer += last_num

        return answer