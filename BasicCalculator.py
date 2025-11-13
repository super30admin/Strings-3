class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        # following the bodmas rule, for any addition, subtraction we can just calculate it with the previous summ, but for / or * first we need to take the change of the previous step and then operate this operation and them sum them up
        # tc  : O(n) , sc : O(1)

        currNum = 0 # curr number
        lastSign = '+'
        calc = 0 # calculation sum so far
        tail = 0 # whats the last operation value, so for / or * we can take this change out of cal and then do the operation

        for i in range(len(s)):
            c = s[i]

            if c.isdigit():
                currNum = currNum * 10 + int(c)

            if (not c.isdigit() and c != ' ') or i == len(s) - 1:
                if lastSign == '+':
                    calc = calc + currNum
                    tail = currNum
                elif lastSign == '-':
                    calc = calc - currNum
                    tail = -currNum
                elif lastSign == '*':
                    res = tail * currNum
                    calc = (calc - tail) + res
                    tail = res
                elif lastSign == '/':
                    res = int(tail / currNum) 
                    calc = calc - tail + res
                    tail = res

                currNum = 0
                lastSign = c

        return calc