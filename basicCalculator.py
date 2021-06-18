class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0: return 0
        stack = []
        result = 0
        num, sign = 0, '+'
        for element in s:
            if element.isdigit():
                num = num * 10 + int(element)
            if element.isdigit() != True or element == s[len(s) - 1]:
                elif sign == '+': stack.append(num)
                elif sign == '-': stack.append(-num)
                elif sign == '*': stack.append(stack.pop() * num)
                else: stack.append(stack.pop() / num)
                sign = element
                num = 0

        while stack.__len__() > 0:
            result += stack.pop()
        return result






