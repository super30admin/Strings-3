class Solution:
    def calculate(self, s: str) -> int:
        if len(s) is None or len(s) == 0:
            return 0
        curr = 0
        calc = 0
        lastsign = '+'
        tail = 0
        # s = s.replace(" ", "")

        for i in range(len(s)):
            c = s[i]
            if c.isnumeric():
                curr = curr * 10 + int(c)
            if (not c.isnumeric() and c != " ") or i == len(s) - 1:
                if lastsign == "+":
                    calc = calc + curr
                    tail = +curr
                elif lastsign == '-':
                    calc = calc - curr
                    tail = -curr

                elif lastsign == '*':
                    calc = calc - tail + tail * curr
                    tail = tail * curr
                elif lastsign == '/':
                    calc = calc - tail + int(tail / curr)
                    tail = int(tail / curr)
                lastsign = c
                curr = 0
        return print(calc)


if __name__ == "__main__":
    obj = Solution()
    obj.calculate("415+21*3*3*2+7551/3-4*39*15/2/3-37705*2/3/2*4/24/2-204+4140")
# output : 5809


# Time Complexity = O(N)
# Space complexity : O(1). No extra space used. Maintained 4 variables i.e curr, calc, tail, lastsign
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
