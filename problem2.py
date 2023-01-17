#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
#declare variables last_op, num,curr, tail. last_op gives the last arithmetic symbol, num gives the result given by arithmetic expression so far, tail tracks the rsult after the last operation. return num at the end after traversing the string. 
class Solution:
    def calculate(self, s: str) -> int:
        last_op='+'
        num=0
        curr=0
        tail=0
        s+='@'

        for i in s:
            if(i not in ['+','-','*','/','@'] ):
                if(i==' '):
                    continue
                curr=(curr*10+int(i))
            else:
                if(last_op=='+'):
                    num+=curr
                    tail=curr
                    last_op=i
                    curr=0
                elif(last_op=='-'):
                    num-=curr
                    tail=-curr
                    last_op=i
                    curr=0
                elif(last_op=='*'):
                    num=(num-tail)+(tail*curr)
                    tail=tail*curr
                    last_op=i
                    curr=0
                elif(last_op=='/'):
                    print(num-tail)
                    print(tail//curr)
                    num=(num-tail)+int(tail/curr)
                    print(tail,num)
                    tail=int(tail/curr)
                    last_op=i
                    curr=0
        print(int(-3/2))
        return num       









