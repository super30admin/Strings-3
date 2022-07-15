# Approach : using stack
# TC O(n)
# SC O(n)
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        res = 0
        lastSign = "+"  # set last sign to + for the beginning
        currNum = 0
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isnumeric():
                currNum = currNum * 10 + int(c)
            # if char is not space and numeric or if we are on the last char of string 
            if (c != ' ' and not c.isnumeric()) or i == len(s) - 1:
                # for positive and negative signs add them with appropriate signs to stack
                if lastSign == "+": stack.append(+currNum)
                elif lastSign == "-": stack.append(-currNum)
                # for multiplication and division pop the stack top and multiply/divide
                # with currNum and then push it back to stack
                elif lastSign == "*": stack.append(stack.pop() * currNum)
                elif lastSign == "/": stack.append(int(stack.pop() / currNum))
                # everytime we are done processing last sign, set currNum to 0 and 
                # update lastSign to currSign
                currNum = 0
                lastSign = c # update to current Sign
        # if stack is not empty, pop it out and add it to res
        while stack:
            res += stack.pop()
        
        return res


# Approach : without using stack space - use running calculations and tail
# as we keep adding and subtracting numbers we maintain whatever last items we added
# as tail. And if a multiply or division operation comes in, we need to remove our tail and
# re-add it
# TC O(n)
# SC O(1)
class Solution:
    def calculate(self, s: str) -> int:
        res = 0
        lastSign = "+"  # set last sign to + for the beginning
        currNum = 0
        
        for i in range(len(s)):
            c = s[i]
            
            if c.isnumeric():
                currNum = currNum * 10 + int(c)
            # if char is not space and numeric or if we are on the last char of string 
            if (c != ' ' and not c.isnumeric()) or i == len(s) - 1:
                if lastSign == "+": 
                    res = res + currNum
                    tail = +currNum
                elif lastSign == "-":
                    res = res - currNum
                    tail = -currNum
                # for multiplication and division pop the stack top and multiply/divide
                # with currNum and then push it back to stack
                elif lastSign == "*":
                    res = res - tail + tail * currNum
                    tail = tail * currNum
                elif lastSign == "/":
                    res = res - tail + int(tail / currNum)
                    tail = int(tail / currNum)
                # everytime we are done processing last sign, set currNum to 0 and 
                # update lastSign to currSign
                currNum = 0
                lastSign = c # update to current Sign
        
        return res