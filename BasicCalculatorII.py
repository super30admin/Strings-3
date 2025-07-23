#TC: O(n)
#SC:O(1)
class Solution:
    def calculate(self, s: str) -> int:
        s = s.strip()
        curr = 0
        prev = 0
        last_sign = "+"
        result = 0
        for index, i in enumerate(s):
            if i.isdigit():
                curr = curr*10+ int(i)
            if (not i.isdigit() and i!= " ") or index == len(s)-1:
                if last_sign == "+" or last_sign == "-":
                    result += prev
                    prev = curr if last_sign == "+" else - curr
                elif last_sign == "*":
                    prev = prev * curr
                elif last_sign == "/":
                    prev = int(prev/curr)
                curr = 0
                last_sign = i

        result += prev   
        return result