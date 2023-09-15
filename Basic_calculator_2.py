# Time Complexity :Stack= O(N), Tail= O(N)
# Space Complexity :Stack= O(N), Tail= O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : The floor division in python rounds -3//2 to -2, so had to take care of this.

# Your code here along with comments explaining your approach


# Tail Solution
from collections import deque
class Solution:
    def calculate(self, s: str) -> int:
        calc=0
        tail=0
        curr=0
        last_sign='+'
        n=len(s)
        for i in range(n):
            if(s[i].isdigit()):
                curr=curr*10+int(s[i])
                # continue
                if(i==n-1):
                    if(last_sign=='+'):
                        calc=calc+curr
                        tail=curr
                    else:
                        if(last_sign=="-"):
                            calc=calc-curr
                            tail=curr*-1
                        else:
                            if(last_sign=='*'):
                                calc=calc-tail+tail*curr
                                tail=tail*curr
                            else:
                                if(tail<0):
                                    r=abs(tail)//curr
                                    r*=-1
                                else:
                                    r=tail//curr
                                calc=calc-tail+r
                                tail=r
                    last_sign=s[i]
                    curr=0
            
            else:
                if((s[i]!=' ') or i==n-1):
                    if(last_sign=='+'):
                        calc=calc+curr
                        tail=curr
                    else:
                        if(last_sign=="-"):
                            calc=calc-curr
                            tail=curr*-1
                        else:
                            if(last_sign=='*'):
                                calc=calc-tail+tail*curr
                                tail=tail*curr
                            else:
                                if(tail<0):
                                    r=abs(tail)//curr
                                    r*=-1
                                else:
                                    r=tail//curr
                                calc=calc-tail+r
                                tail=r
                    last_sign=s[i]
                    curr=0
        return calc




# Stack Solution
from collections import deque
class Solution:
    def calculate(self, s: str) -> int:
        st=deque([])
        curr_num=0
        last_sign='+'
        n=len(s)

        print(3//2)
        for i in range(n):
            if(s[i].isdigit()):
                curr_num=curr_num*10+int(s[i])
                # print(curr_num, i)
                # continue
            # else:
            if((s[i]!=" " and (s[i].isdigit()==False)) or i==n-1):
                # print(s[i], i, curr_num, st)
                if(last_sign=='+'):
                    st.append(curr_num)
                else:
                    if(last_sign=='-'):
                        st.append(curr_num*-1)
                    else:
                        if(last_sign=='*'):
                            st.append(st.pop()*curr_num)
                        else:
                            if(last_sign=='/'):
                                popped=st.pop()
                                if(popped<0):
                                    r=abs(popped)//curr_num
                                    r*=-1
                                else:
                                    r=popped//curr_num
                                st.append(r)
                # print(s[i], i, curr_num, st)
                last_sign=s[i]
                curr_num=0
        result=0
        while(len(st)):
            result+=st.pop()
        return int(result)