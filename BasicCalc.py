# TC - O(n) => length of string
# SC - O(1)
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """

        lastSign = "+"
        size = len(s)

        calc, tail, curr = 0, 0, 0

        for index, c in enumerate(s):
            if c.isdigit():
                # print((ord(c) - ord('0')))
                curr = curr * 10 + (ord(c) - ord('0'))

            if not c.isdigit() or index == size - 1:

                if lastSign == "+":
                    calc = calc + curr
                    tail = 1 * curr
                elif lastSign == "-":
                    calc = calc - curr
                    tail = -1 * curr
                elif lastSign == "*":
                    calc = (calc - tail) + (tail * curr)
                    tail = (tail * curr)
                else:
                    calc = (calc - tail) + (tail / curr)
                    tail = (tail / curr)
                lastSign = c
                curr = 0

        return calc
