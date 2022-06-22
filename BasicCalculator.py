#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def calculate(self, s: str) -> int:
        lastSymbol='+'
        lastNum=0
        lst,i=[],0
        while i<len(s):
            if s[i] in "0123456789":
                while i<len(s) and s[i] in "0123456789":
                    lastNum=lastNum*10+int(s[i])
                    i+=1
                if lastSymbol=="*":
                    lst.append(lst.pop()*lastNum)
                elif lastSymbol=="/":
                    num=lst.pop()
                    if num <0:
                        lst.append(-1*(-num//lastNum))
                    else:
                        lst.append(num//lastNum)
                elif lastSymbol == '-':
                    lst.append(-1*lastNum)
                else:
                    lst.append(lastNum)
                lastNum=0
            if i<len(s) and s[i] in ['+','-','*','/']:
                lastSymbol=s[i]
            i+=1
        return sum(lst)
        