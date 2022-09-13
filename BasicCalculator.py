#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def calculate(self, s: str) -> int:
        if s == '' or len(s) == 0:
            return 0
        curr = 0
        lst = []
        res = 0
        lastsign = '+'

        for i in range(len(s)):
            ch = s[i]
            if ch.isdigit():

                curr = curr*10 + ord(ch) - ord('0')

            if (not ch.isdigit() and ch != ' ') or (i == len(s)-1):


                if lastsign == '+':
                    lst.append(curr)

                elif lastsign == '-':
                    lst.append(-curr)

                elif lastsign == '*':

                    lst.append(lst.pop()*curr)

                else:

                    lst.append(int(lst.pop()/curr))

                curr = 0
                lastsign = ch

        while lst:
            res += lst.pop()

        return res
