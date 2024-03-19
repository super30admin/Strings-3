'''
TC: O(n)
SC: O(1)
'''
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        curr = 0
        lastSign = '+'
        for i, character in enumerate(s):
            if character == ' ':
                continue
            if character.isdigit():
                curr = curr*10 + int(character)
            else:
                if character == '+' or character == '-':
                    curr = curr if lastSign == '+' else -curr
                    stack.append(curr)
                    curr = 0
                    lastSign = character
                elif character == '(':
                    stack.append(lastSign + character)
                    lastSign = '+'
                elif character == ')':
                    if lastSign == '-':
                        curr = -curr
                        lastSign = '+'
                    while stack[-1] != '+(' and stack[-1] != '-(':
                        curr = curr + stack.pop()
                    if stack[-1] == '-(':
                        lastSign = '-'
                    stack.pop()
        curr = curr if lastSign == '+' else -curr
        while stack:
            curr += stack.pop()
        return curr
s = Solution()
print(s.calculate("1 + 1"))
print(s.calculate(" 2-1 + 2 "))
print(s.calculate("(1+(4+5+2)-3)+(6+8)"))
print(s.calculate("- (3 + (4 + 5))"))