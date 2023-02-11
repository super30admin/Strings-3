from queue import LifoQueue

class Solution:
    def calculate(self, s: str) -> int:

        # TC: O(n), SC: O(1) 
        s = s.strip()
        lastSign = '+'
        tail = 0
        num = 0
        res = 0

        for i, c in enumerate(s):
            if c.isdigit():
                num = num*10 + int(c)
            if (not c.isdigit() and c != ' ') or i == len(s)-1:
                if lastSign == '+':
                    res += num
                    tail = num * (1)
                elif lastSign == '-':
                    res -= num
                    tail = num * (-1)
                elif lastSign == '*':
                    res = res - tail + (tail * num)
                    tail = tail * num
                elif lastSign == '/':
                    res = res - tail + int(tail / num)
                    tail = int(tail / num)
                    
                num = 0
                lastSign = c

        return res

      
        # TC: O(n), SC: O(n)
        lastSign = '+'
        num = 0
        res = 0

        # Stack
        calcNum = LifoQueue()

        for i, c in enumerate(s):
            if c.isdigit():
                num = num * 10 + int(c)
            if (not c.isdigit() and c != ' ') or i == len(s) - 1:
                if lastSign == '-':
                    num = -1 * num
                    calcNum.put(num)    
                elif lastSign == '+':
                    num = 1 * num
                    calcNum.put(num)
                elif lastSign == '*':
                    prevNum = calcNum.get()
                    currNum = prevNum * num
                    calcNum.put(currNum)
                elif lastSign == '/':
                    prevNum = calcNum.get()
                    currNum = int(prevNum / num)
                    calcNum.put(currNum)
                num = 0
                lastSign = c

        while not calcNum.empty():
            res += calcNum.get()

        return res
