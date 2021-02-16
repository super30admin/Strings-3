#Time Complexity :O(n) n is len od string
#Space Complexity :O(n/2) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack=[]
        preSign='+'
        curNum=0
        
        for i in range(len(s)):
            if(s[i].isdigit()):
                curNum=curNum*10+int(s[i])         
            if((not s[i].isdigit() and s[i]!=' ') or i==len(s)-1):
                if(preSign=='+'):
                    stack.append(curNum)
                elif(preSign=='-'):
                    stack.append(-curNum)
                #IF * then pop number from stack multipply with curr and push back
                elif(preSign=='*'):
                    stack.append(stack.pop()*curNum)
                #IF / then pop number from stack divide with curr and push back
                elif(preSign=='/'):
                    ans=stack.pop()
                    if(ans<0):
                        ans*=-1
                        res=ans//curNum
                        stack.append(-res)
                    else:
                        stack.append(ans//curNum)
                    
                curNum=0
                preSign=s[i]
                
        res=0
        #the values left are just add and sub values so add up all values to get result
        while(stack):
            res+=stack.pop()
        return res