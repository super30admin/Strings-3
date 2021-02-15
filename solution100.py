#Time COmplexity:O(n)
#Space Complexity:O(n)
class Solution:
    def calculate(self, s: str) -> int:
        result=0                                        #declare final result variable
        if len(s)==0:
            return 0
        n=len(s)
        lastsign='+'                                    #keeps track of previous sign encountered
        num=0
        st=[]                                           #declare a stck that holds all the numbers
        for i in range(n):                              #for every char in string s
            c=s[i]                                      
            if c.isnumeric():                           #if char is a number calculate the total number
                num=num*10+int(c)
            if (not c.isnumeric() and c!=" ") or i==n-1:    #else if char is not a number or space or we are at the last position of the string
                if lastsign=='+':                           #if last sign is + sign append num into stack and make c the last sign
                    st.append(num)
                elif lastsign=='-':                         #if last sign is - sign append -num into stack and make c the last sign
                    st.append(-num)
                elif lastsign=='*':                         #if last sign is * sign multiply top lement of stack with number and append into stack and make c the last sign
                    st.append(st.pop()*num)
                else:
                    st.append(int(st.pop()/num))            #if last sign is / sign divide top lement of stack by number and append into stack and make c the last sign
                lastsign=c                                  #updating lastsign for every call
                num=0                                       #reassigning num to zero
                
        while st:
            result+=st.pop()                                #adding all elements within the stack to the result
            
        return result