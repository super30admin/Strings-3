'''
TC: O(n)
SC: O(1)
'''
class Solution:
    def calculate(self, s: str) -> int:
        prev = 0
        calc = 0
        prevsign = "+"
        i = 0
        s = s.strip()
        slen = len(s)
        
        while i < slen:
            if s[i] == " ":
                i += 1
                continue
            curr = 0
            while i < slen and s[i].isdigit():
                curr = 10 * curr + int(s[i])
                i += 1
            if i == slen or not s[i].isdigit():
                if prevsign == "+":
                    calc += curr
                    prev = curr
                elif prevsign == "-":
                    calc -= curr
                    prev = -curr
                elif prevsign == "*":
                    calc = calc - prev + prev * curr
                    prev = prev * curr 
                elif prevsign == "/":
                    calc = calc - prev + int(prev / curr)
                    prev = int(prev / curr)
                if i != slen:
                    prevsign = s[i]
            i += 1
        
        return calc