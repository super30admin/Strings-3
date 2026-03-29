# problem 2 

# https://leetcode.com/problems/basic-calculator-ii/

class Solution:
    def calculate(self, s: str) -> int:
        arr = []
        currnum = 0 
        lastsign = '+'
        result = 0 
        for i in range(len(s)):
            ch = s[i]
            if ch.isdigit():
                currnum = currnum * 10 + int(ch)
            
            if (not ch.isdigit() and ch != ' ') or i == len(s) - 1:
                if lastsign == '+':
                    arr.append(currnum)
                elif lastsign == '-':
                    arr.append(-currnum)
                elif lastsign == '*':
                    last_val = arr.pop()
                    arr.append(last_val*currnum)
                elif lastsign == '/':
                    last_val = arr.pop()
                    arr.append(int(last_val/currnum))
                currnum = 0
                lastsign = ch
        
        while arr:
            result+=arr.pop()
        return result