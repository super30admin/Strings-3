class Solution:
    def calculate(self, s):
        """
            https://leetcode.com/problems/basic-calculator/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the length of 's'
        """
        result, num, sign = 0, 0, 1
        stack = []
        for c in s:
            if c.isdigit():
                num = 10 * num + int(c)
            elif c == '+':
                result += sign * num
                num = 0
                sign = 1
            elif c == '-':
                result += sign * num
                num = 0
                sign = -1
            elif c == "(":
                stack.append(result)
                stack.append(sign)
                sign = 1
                result = 0
            elif c == ")":
                result += sign * num
                result *= stack.pop()
                result += stack.pop()
                num = 0
        return result + num * sign


if __name__ == '__main__':
    print(Solution().calculate(" 2-1 + 2 "))
