class Solution:
    def calculate(self, s: str) -> int:

        if (s == None or len(s) == 0):
            return 0

        digits = '0123456789'
        operator = '+-*/'
        stack = []
        cursor = 0
        value = 0
        lastSign = '+'

        while (cursor < len(s)):
            #  if number occurred
            if s[cursor] in digits:
                value = (10 * value) + int(s[cursor])

            #  if operator ocurred
            if (s[cursor] in operator or cursor == len(s) - 1):
                if lastSign == '+':
                    stack.append(value)
                    value = 0
                elif lastSign == '-':
                    stack.append(-value)
                    value = 0

                elif lastSign == '*':
                    temp = stack.pop()
                    stack.append(value * temp)
                    value = 0

                elif lastSign == '/':
                    temp = stack.pop()
                    stack.append(int(temp / value))
                    value = 0
                lastSign = s[cursor]
            cursor += 1
        result = 0
        while (len(stack) > 0):
            result += (stack.pop())
        return result








