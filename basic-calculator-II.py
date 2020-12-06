class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        last_sign = '+'
        res = 0
        num = 0
        for i in range(len(s)):

            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if (s[i].isdigit() == False and s[i] != ' ') or i == len(s) - 1:
                if last_sign == '+':
                    stack.append(num)
                if last_sign == '-':
                    stack.append(-num)
                if last_sign == '*':
                    l = stack.pop()
                    stack.append(l * num)
                if last_sign == '/':

                    l = stack.pop()
                    if l < 0:
                        x = -l
                        # print(x)
                        div = x / num
                        # print(div)
                        stack.append(-div)
                    else:

                        stack.append(l / num)
                num = 0
                last_sign = s[i]
                # print(stack)
        while stack != []:
            i = stack.pop()
            res += i
        return res
    # time and space=O(n)