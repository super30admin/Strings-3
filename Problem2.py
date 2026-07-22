## Problem2:Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)
# Time Complexity: O(n),We make a single pass through the string, index by index. Each character does only a fixed, constant amount of work (digit build, or one of the four sign branches), so total work scales linearly with the length of the string.
# Space Complexity: O(1), Instead of a stack that could grow up to O(n) with one entry per number, we only keep a handful of running variables (current_number, current_total, tail, lastsign). "tail" plays the role of the stack's top element, so we never need the rest of the stack.

# Approach:
# Walk the string left to right, building up numbers digit by digit. Whenever we hit an operator (or reach the end of the string), the number just built is complete, so we apply the PREVIOUS sign(lastsign) to combine it into current_total.
# For + and -, we just add or subtract the number normally.
# For * and /, we cannot simply add to current_total, because the last term added needs to be replaced, not added to. So we first undo the last term (current_total - tail), then add back the correctly multiplied/divided version. "tail" always remembers the value of the most recently added term, acting as a substitute for a stack's top element, without needing an actual stack.

class Solution:
    def calculate(self, s: str) -> int:
        current_number = 0     # builds up the current number digit by digit
        current_total = 0      # running sum of all finalized terms
        lastsign = '+'         # operator that appeared before current_number (starts as '+' since first number is just added)
        tail = 0                # value of the most recently added term (stand-in for stack's top)

        for i in range(len(s)):
            c = s[i]            # character at this position

            if c.isdigit():
                # build multi-digit numbers, e.g. '1' then '2' is 12
                current_number = current_number * 10 + int(c)

            # when we hit an operator, or when we reach the last character
            if (not c.isdigit() and c != ' ') or i == len(s) - 1:

                if lastsign == '+':     # simply add the number to the total    
                    current_total = current_total + current_number
                    tail = +current_number   # this term's value, for future * or /

                elif lastsign == '-':       # simply subtract the number from the total
                    current_total = current_total - current_number
                    tail = -current_number   # store signed value, needed if a '*' follows later

                elif lastsign == '*':
                    # undo the previous term (current_total - tail),
                    # then add back the term multiplied by current_number
                    current_total = (current_total - tail) + (tail * current_number)
                    tail = tail * current_number   # update tail to the new term's value

                elif lastsign == '/':
                    current_total = (current_total - tail) + int(tail / current_number)
                    tail = int(tail / current_number)

                current_number = 0   # reset builder for the next number
                lastsign = c          # remember this operator for the next flush

        return current_total
