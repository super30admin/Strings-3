class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
#         Time complexity - O(n)
# Space complexity - O(n)
        #1) one stack
        #to maintain precedence, deal with (* or /) operations at that moment only> just put final value 
        #maintain last sign
        #2) main tain 2 stacks > digtis and operator 
        stack=[]
        num=0
        ans=0
        #start with default  plus sign
        lastsign='+'
        for i in range(len(s)):
            c=s[i]
            if c.isdigit():
                # for multiple digit numbers, club them
                num=num*10+int(c)
            #if operator or last char
            if (not c.isdigit() and c!=' ') or (i==len(s)-1):
                #when '+' / '-' operator is found then push the temp value into stack with its sign
                #otherwise pop element from the stack, perform operation between popped element and temp and push back to stack.
                if lastsign=='+':
                    stack.append(num)
                elif lastsign=='-':
                    stack.append(-num)
                elif stack and lastsign=='*':
                    stack.append(stack.pop()*num)
                elif stack and lastsign=='/':
                    stack.append(stack.pop()/num)
                #get ready for new digit
                num=0
                #store last operation to be performed
                lastsign=c
        #at the end, stack has only operations left to be performed
        return sum(stack)
                