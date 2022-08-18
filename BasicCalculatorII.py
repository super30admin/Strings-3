class Solution:
    def calculate(self, s: str) -> int:
        currnum = 0
        curroper = '+'
        stk = []
        s+='+'
        for i in s:
            if i.isdigit():
                currnum = currnum*10 + int(i)
            elif i == " ":
                pass
            else:
                if curroper == '+':
                    stk.append(currnum)
                elif curroper == '-':
                    stk.append(-currnum)
                elif curroper == '*':
                    p = stk.pop()
                    stk.append(p*currnum)
                elif curroper == '/':
                    p = stk.pop()
                    stk.append(int(p/currnum))
                currnum = 0
                curroper = i
        return sum(stk)