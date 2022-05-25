#basic calculator II
# // Time Complexity :  O(N) 
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def calculate(self, s: str) -> int:
    print(len(s))
    stack=[]
    curr=0
    sign='+'
    for p, i in enumerate(s):
        if(i.isnumeric()):
            curr=curr*10+int(i)                 #calculate the current number 
        if(not i.isnumeric() and i!=" ") or p==len(s)-1:
            if sign=="+":                       #if the sign is +, then just add the element to the stack
                stack.append(curr)

            elif sign=="-":                     #if its -, add the negated value to the stack
                stack.append(-curr)

            elif sign=="*":
                stack.append(stack.pop()*curr)      #if its *, pop the last element out and multiply with the curent one

            else:
                tmp=stack.pop()
                if (tmp//curr < 0 and tmp%curr!=0):         #if its /, then pop the last element out and divide with the current one
                    stack.append(tmp//curr+1)
                else:
                    stack.append(tmp//curr)
            sign = i
            curr=0
    return sum(stack)