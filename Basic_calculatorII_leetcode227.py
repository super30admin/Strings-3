class Solution:
    def calculate(self, s: str) -> int:
        # Stack TC -O(n) SC - O(n/2) = O(n) because max n/2 would be operator
        s = "".join(s.split())
        n = len(s)
        output = 0

        stack = []
        i = 0
        while i < n:
            if s[i].isnumeric():
                num, i = self.process_num(i, n, s)
                stack.append(str(num))

            elif s[i] == '+' or s[i] == '-':
                operator = s[i]
                num, i = self.process_num(i + 1, n, s)
                val = operator + str(num)
                stack.append(val)

            elif s[i] == '*':
                prevv = int(stack.pop())
                nextt, i = self.process_num(i + 1, n, s)
                val = prevv * nextt
                stack.append(str(val))

            elif s[i] == '/':
                prevv = int(stack.pop())
                nextt, i = self.process_num(i + 1, n, s)
                val = int(prevv / nextt)
                stack.append(str(val))

        while stack:
            output += int(stack.pop())
        return output

    def process_num(self, i, n, s):
        num = int(s[i])
        while i + 1 < n and s[i + 1].isnumeric():
            num = num * 10 + int(s[i + 1])
            i += 1
        i += 1
        return num, i











