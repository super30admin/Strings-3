"""
I implemented this using a tail pointer technique, evaluating the expression in one pass without using a stack. For + and -, I add/subtract the current number directly and update the tail. For * and /, I backtrack using the tail to apply operator precedence correctly.
Time Complexity: O(n)
SPace Complexity: O(1)
"""
class Solution:
    def calculate(self, s: str) -> int:
        s = s.replace(" ", "") + "+"
        if len(s) == 0:
            return 0
        curr = 0
        result = 0
        tail = 0
        lastSign = "+"
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                curr = curr * 10 + int(char)
            elif char in "+-*/":
                if lastSign == "+":
                    result += curr
                    tail = curr
                elif lastSign == "-":
                    result -= curr
                    tail = -curr
                elif lastSign == "*":
                    result = result - tail + (tail * curr)
                    tail = tail * curr
                else:
                    divided = int(tail / curr)
                    result = result - tail + divided
                    tail = divided
                curr = 0
                lastSign = char
        return result    