# Time Complexity :
# O(N) - length of string s

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

# We iterate through the expression string. When we encounter a digit, we store the value in current, if it's a space, we skip, if it's an expression, we process
# The processing when we see an expression as follows - if the previous seen expression (initialized to +) is an addition or subtraction sign, we perform that operation with the calculated value and the current value. We store the tail as the current change made to calculated value
# If it's multiplication or subtraction that is the previous expression, we first undo the operation previous to that expression, and multiply/divide the curr value by the tail and add it to the calculated value. Update tail to change made to the calculated value
#Return calculated value

class Solution:
    def calculate(self, s: str) -> int:
        if len(s) == 0 :
            return 0
        curr = 0
        calc = 0 
        tail = 0
        lastsign = '+'
        for i,char in enumerate(s) :
            if char.isdigit():
                curr = curr * 10 + int(char)
            if (not char.isdigit() and char != ' ') or i == len(s) -1 :
                if lastsign == '+':
                    calc = calc+curr
                    tail = curr
                elif lastsign == '-':
                    calc = calc - curr
                    tail = -1 * curr
                elif lastsign == '*':
                    calc = calc - tail + curr*tail
                    tail = curr* tail
                elif lastsign == '/':
                    calc = calc - tail+ int(tail/curr)
                    tail = int(tail/curr)
                curr = 0
                lastsign = char
        return calc
