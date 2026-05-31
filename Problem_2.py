# class Solution:
#     def calculate(self, s):
#         s = s.strip()
#         ls = len(s)
#         st = []
#         currNum = 0
#         lastSign = "+"
#         for i in range(ls):
#             c = s[i]
#             if c.isdigit():
#                 currNum = currNum * 10 + int(c)
#             if (not c.isdigit() and c != " ") or i == ls - 1:
#                 if lastSign == "+":
#                     st.append(currNum)
#                 elif lastSign == "-":
#                     st.append(-currNum)
#                 elif lastSign == "*":
#                     st.append(currNum * st.pop())
#                 elif lastSign == "/":
#                     st.append(int(st.pop() / currNum))

#                 currNum = 0
#                 lastSign = c

#         return sum(st)


class Solution:
    def calculate(self, s):
        s = s.strip()
        ls = len(s)
        lastSign = "+"
        result = 0
        currNum = 0
        lastNum = 0

        for i in range(ls):
            c = s[i]
            if c.isdigit():
                currNum = currNum * 10 + int(c)
            if (not c.isdigit() and c != " ") or i == ls - 1:
                if lastSign == "+":
                    result += currNum
                    lastNum = currNum
                elif lastSign == "-":
                    result -= currNum
                    lastNum = -currNum
                elif lastSign == "*":
                    result = result - lastNum + (currNum * lastNum)
                    lastNum = currNum * lastNum
                else:
                    result = result - lastNum + int(lastNum / currNum)
                    lastNum = int(lastNum / currNum)

                currNum = 0
                lastSign = c

        return result
