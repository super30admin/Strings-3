# Time Complexity: O(n), where n - length of the string
# Space Complexity: O(n)

class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0

        stack = []
        num = 0
        last_sign = '+'
        result = 0

        for i in range(len(s)):
            ch = s[i]

            # If the char is a digit, update the num
            if ch.isdigit():
                num = num * 10 + (ord(ch) - ord('0'))

            # Else, perform the corresponding operation and update the num and last_sign
            if (not ch.isdigit() and ch != ' ') or i == len(s) - 1:
                if last_sign == '+':
                    stack.append(num)

                elif last_sign == '-':
                    stack.append(-num)

                elif last_sign == '*':
                    stack.append(stack.pop() * num)

                else:
                    stack.append(int(stack.pop() / num))

                num = 0
                last_sign = ch

        # Add all remaining numbers from stack
        while stack:
            result += stack.pop()

        return result