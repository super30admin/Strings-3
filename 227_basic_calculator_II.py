class Solution:
    def calculate(self, s: str) -> int:
        """
            https://leetcode.com/problems/basic-calculator-ii/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the length of the string
        """
        if not s: return 0
        stack = []
        num = 0
        last_sign = '+'  # dummy sign
        for idx, c in enumerate(s):
            if c.isdigit():
                num = num * 10 + int(c)
            if ((not c.isdigit()) and c != ' ') or idx == len(s) - 1:
                if last_sign == '-':
                    stack.append(-num)
                elif last_sign == '+':
                    stack.append(num)
                elif last_sign == '*':
                    stack.append(stack.pop() * num)
                elif last_sign == '/':
                    stack.append(int(stack.pop() / float(num)))
                # new sign
                last_sign = c
                num = 0

        return sum(stack)


if __name__ == '__main__':
    Solution().calculate("14-3/2")
