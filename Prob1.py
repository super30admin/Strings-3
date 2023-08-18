class Solution:
    def calculate(self, s: str) -> int:

        #Method 1 - Stack -> O(n) TC and SC
        # curr=0
        # lastsign='+'
        # stack=[]
        # n=len(s)

        # for i in range(n):
        #     c=s[i]

        #     if c.isdigit():
        #         curr=curr*10+int(c)
        #     if (not c.isdigit() and c!=' ') or i==n-1: #there can be spaces -> do nothing also for last digit we need to calculate it and push it even if it's a digit. 
        #         if lastsign=='+':
        #             stack.append(curr)
        #         elif lastsign=='-':
        #             stack.append(-1*curr)
        #         elif lastsign=='*':
        #             temp=stack.pop()
        #             stack.append(temp*curr)
        #         else:
        #             temp=stack.pop()
        #             stack.append(int(temp/curr))
        #         curr=0 #each time it's a sign we reset curr=0 and update lastsign to current sign-> c
        #         lastsign=c
        # res=0
        # while stack:
        #     res+=stack.pop()
        # return res

        #Method 2 - Tail Concept -> O(n) TC and SC O(1)
        curr=0
        calc=0
        tail=0
        n=len(s)
        lastsign='+'
        for i in range(n):
            c=s[i]
            if c.isdigit():
                curr=curr*10+int(c)
            if (not c.isdigit() and c!=' ') or i==n-1:
                if lastsign=='+': #formula for calc and tail. 
                    calc=calc+curr
                    tail=curr
                elif lastsign=='-':
                    calc=calc-curr
                    tail=-1*curr
                elif lastsign=='*':
                    calc=calc-tail+(tail*curr)
                    tail=curr*tail
                else:
                    calc=calc-tail+(int(tail/curr))
                    tail=int(tail/curr)
                lastsign=c
                curr=0
        return calc
                






        