# if digit, add 0 as curr_num and last sign repeats
# if operators process number till now based on sign and update cals in
# same as expression add op prob where we subtract the previous value and make it original and then multiply

# ex ,calc ,tail
# + calc+curr +curr
# - calc-curr  -ConnectionRefusedError
# *(calc-tail)+(tail*curr)


# Q))2+3-4*6-5*2
# calc. tail. curr num(ex, calc=calc+curr_num,curr_num) last sign
# (0,0,0,+)
# (0,0,2,+)
# (2,2,0,+)
# (2,2,3,+)
# (5,3,0,-)
# (5,3,4,-)
# (1,-4,0,*)
# (1,,-4,6,*)
# (-19,-24,0,-)
# (-19,-24,5,-)
# (-19-5,-5,0,*)
# (-24,-5,2,*)
# (-29,-5*2,2,*)


class Solution:
    def calculate(self, s: str) -> int:
        n = len(s)
        calc = 0
        tail = 0
        curr_num = 0
        last_sign = "+"

        for i in range(n):
            c = s[i]

            if c.isdigit():
                curr_num = curr_num * 10 + int(c)

            if (not c.isdigit() and c != " ") or i == n - 1:
                if last_sign == "+":
                    calc += curr_num
                    tail = curr_num
                elif last_sign == "-":
                    calc -= curr_num
                    tail = -curr_num
                elif last_sign == "*":
                    calc = calc - tail + (tail * curr_num)
                    tail = tail * curr_num
                elif last_sign == "/":
                    calc = calc - tail + int(tail / curr_num)
                    tail = int(tail / curr_num)

                curr_num = 0
                last_sign = c

        return calc


# time complexity is O(n)
# space complexity is O(1)
