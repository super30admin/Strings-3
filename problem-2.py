# Leetoce Execution: YES
# Space Complxity: O(n)
# Time Complexity: O(n)
class Solution:
    def calculate(self, s: str) -> int:
        
        result=0
        stack=[]
        flag=0
        num=""
        i=0
        # first we loop thourgh the string given and then we move the i for each iter.
        # so if we encounter a number we loop until we not uencounter a number and
    # perform operations such as * / if that is the top of the stack we computer and push the result in the stack else we just push it. 
        while(i<len(s)):
            # if we gte a space we dont have to do anything about it so move forward
            if s[i]==" ":
                i+=1
                continue
            # this is where we check if the current index val is a number 
            if ord(s[i])>=48 and ord(s[i])<=57:
                # get all the numbers 
                while(i<len(s) and (ord(s[i])>=48 and ord(s[i])<=57)):
                    num=num+s[i]
                    i+=1
                # computer and push
                if stack and stack[-1]=='*':
                    stack.pop()
                    val=int(stack.pop())*int(num)
                    stack.append(val)
                elif stack and stack[-1]=='/':
                    stack.pop()
                    val=int(stack.pop())//int(num)
                    stack.append(val)
                else:
                    stack.append(num)
                num=""
                i-=1
            # we also wanna make sure what to do if the number is a symbol and if there is a single number that means we need to computer somthing and hence make flag 0
            else:
                flag=1
                stack.append(s[i])
            i+=1
        
        # we check  if the flag is 0 if it is that means there is no operator in the string given and we just happen to return the entire string as is but thaat is in the index 0 of the stack since we push it in the stack 
        # we do this because we may even have some spaces which are removed in the above loop and only the number is kept in the stack 0
        if flag==0:
            return stack[0]
        i=1
        result=int(stack[0])
        # now we evaluate the + and - operations in sequancefrom 0 to len 
        while(i<=len(stack)-2):
            op=stack[i]
            i+=1
            val=int(stack[i])
            print(result,op,val)
            if op=="+":
                result=result+val
            elif op=="-":
                result-=val
            i+=1
        
        return result
                
            
        