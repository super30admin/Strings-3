#TC:0(N)
#SC:O(N)
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        lastsign = "+"
        num = 0
        result = 0

        if s == None or len(s) == 0:
            return 0

        for i in range(len(s)):
            ch = s[i]
            # if number
            if ch.isnumeric():
                num = num * 10 + int(ch)

            # if character
            if ch != " " and not ch.isnumeric() or i == len(s) - 1:
                if lastsign == "+":
                    stack.append(num)
                elif lastsign == "-":
                    stack.append(-num)
                elif lastsign == "*":
                    stack.append(int(stack.pop() * num))
                else:
                    stack.append(int(stack.pop() / num))
                lastsign = ch
                num = 0
        while stack:
            result = result + stack.pop()
        return int(result)