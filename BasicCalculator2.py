# class Solution:
#     def calculate(self, s: str) -> int:
#         s=s.strip()
#         st = []
#         lastsign , curr= '+', 0
#         for i in range(len(s)):
#             c = s[i]
#             if c.isdigit():
#                 curr=curr*10+int(c)
#             if (not c.isdigit() and c!= ' ') or i == len(s)-1:
#                 if lastsign == '+':
#                     st.append(curr)
#                 elif lastsign == '-':
#                     st.append(-curr)
#                 elif lastsign == '*':
#                     st.append((st.pop())*curr)
#                 elif lastsign == '/':
#                     st.append(int(st.pop() / curr))
#                 curr = 0
#                 lastsign = c
#         res = 0
#         while st:
#             res+=st.pop()
#         return res

# class Solution:
#     def calculate(self, s: str) -> int:
#         s=s.strip()
#         st = []
#         lastsign , curr= '+', 0
#         for i in range(len(s)):
#             c = s[i]
#             if c.isdigit():
#                 curr=curr*10+int(c)
#             if (not c.isdigit() and c!= ' ') or i == len(s)-1:
#                 if lastsign == '+':
#                     st.append(curr)
#                 elif lastsign == '-':
#                     st.append(-curr)
#                 elif lastsign == '*':
#                     st.append((st.pop())*curr)
#                 elif lastsign == '/':
#                     st.append(int(st.pop() / curr))
#                 curr = 0
#                 lastsign = c
#         res = 0
#         return sum(st)

class Solution:
    def calculate(self, s: str) -> int:
        s=s.strip()
        st = []
        lastsign , curr= '+', 0
        res, tail = 0, 0
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                curr=curr*10+int(c)
            if (not c.isdigit() and c!= ' ') or i == len(s)-1:
                if lastsign == '+':
                    res = res+curr
                    tail = curr
                elif lastsign == '-':
                    res = res-curr
                    tail = -curr
                elif lastsign == '*':
                    res = res-tail+(tail) * curr
                    tail = tail*curr
                elif lastsign == '/':
                    res = res-tail+int((tail) / curr)
                    tail = int(tail/curr)
                curr = 0
                lastsign = c
        return res

        

        

        