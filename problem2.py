#Time Complexity : O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes

class Solution:
    def calculate(self, s: str) -> int:
        calc, curr, tail, result = 0, 0, 0, 0
        last_exp = "+"

        for i in range(len(s)):
            c = s[i]

            if c.isdigit():
                curr = curr * 10 + int(c)
            
            if not c.isdigit() and c != " " or i == len(s) - 1:
                if last_exp == "+":
                    result += calc
                    calc = curr
                elif last_exp == "-":
                    result += calc
                    calc = -curr
                elif last_exp == "*":
                    calc *= curr
                else:
                    if curr == 0:
                        return 0
                    calc = int(calc / curr)
                curr = 0
                last_exp = c
        
        return result + calc
