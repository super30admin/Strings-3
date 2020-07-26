#Time Complexity: O(n)
#Space complexity: O(n)

'''
Straighforward solution, keep a stack , if we encounter a symbol , it means
we're done with the number, if last number was a multiplication (or division), 
we pop from the stack multiply and add to stack. Else we just add to the stack.

'''

class Solution:
    def calculate(self, s: str) -> int:
        if not s:
            return 0
        st=[]
        prev_sign,prev_num="+",0
        for i,c in enumerate(s):
            if c.isnumeric():
                prev_num=prev_num*10+int(c)
            if (c!=" "and not c.isnumeric()) or i==len(s)-1 :
                if prev_sign=="*":st.append(prev_num*st.pop())
                elif prev_sign=="/": st.append(int(st.pop()/prev_num))
                elif prev_sign=="+": st.append(prev_num)
                else:st.append(-1*prev_num)
                prev_num=0
                prev_sign=c
        return sum(st)
