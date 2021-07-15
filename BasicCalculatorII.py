class Solution:
    def calculate(self, s: str) -> int:
        """Using method using in add expression operators leetcode prob
        Time complexity-O(n)
        Space complexity-O(1)"""
        s=s.strip()
        lastsign="+"
        tail=0
        calc=0
        num=0
        for i in range(len(s)):
            print(tail, calc, num)
            if s[i].isnumeric():
                print(s[i])
                if int(s[i])<0:
                    num=num*10-int(s[i])
                else:
                    num=num*10+int(s[i])
            if (s[i]!=" " and (not s[i].isnumeric() or i==len(s)-1)):
                print(":;;;", lastsign)
                if lastsign=="+":
                    tail=num
                    calc+=num
                    num=0
                elif lastsign=="-":
                    tail=-1*num
                    calc-=num
                    num=0
                elif lastsign=="*":
                    calc=(calc-tail)+tail*num
                    tail=tail*num
                    num=0
                elif lastsign=="/":
                    calc=(calc-tail)+int(tail/num)
                    tail=int(tail/num)
                    num=0
                lastsign=s[i]
        return calc
            
        """Brute Force approach using Stack
        Time complexity-O(n)
        Space Complexity-O(n)"""
        # s=s.strip()
        # stack=[]
        # result=0
        # if not s:
        #     return 0
        # lastsign="+"
        # num=0
        # for i in range(len(s)):
        #     if s[i].isnumeric():
        #         num=num*10+int(s[i])
        #     if (s[i]!=" " and (not s[i].isnumeric() or i==len(s)-1)):
        #         if lastsign=="+":
        #             stack.append(num)
        #         elif lastsign=="-":
        #             stack.append(-1*num)
        #         elif lastsign=="*":
        #             stack.append(stack.pop()*num)
        #         else:
        #             if num!=0:
        #                 stack.append(int(stack.pop()/num))             
        #         lastsign=s[i]
        #         num=0
        # while stack:
        #     result+=stack.pop()
        # return result
                
                
            
            
        