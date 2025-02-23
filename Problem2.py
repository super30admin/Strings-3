# Stack approach: multiply and divide by pop and append
# TC: O(n)
# SC: O(n)
# alternate approach: using tail and storing the prev calc

class Solution:
    def calculate(self, s: str) -> int:
        if not s:
            return 0

        stack = []
        num = 0
        operator = "+"
        s += "+"
        for i, ch in enumerate(s):
            if ch.isdigit():
                num = num * 10 + int(ch)
            if ch in "+-*/" or i == len(s) - 1:
                if operator == "+":
                    stack.append(num)
                if operator == "-":
                    stack.append(-num)
                if operator == "*":
                    stack.append(stack.pop() * num)
                if operator == "/":
                    stack.append(int(stack.pop() / num))
                
                operator = ch
                num = 0
        return sum(stack)

