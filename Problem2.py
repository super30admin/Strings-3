#Time complexity is O(n)
#Space complexity is O(1)
#Code ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        if(s==None):
            return 0
        #Removing extra spaces at the start and end of the string
        s=strip(s)
        #Intializing all the required variables
        lastSign="+"
        curr=0
        calc=0
        tail=0
        n=len(s)
        #Wewill be going through each character in the given string
        for i in range(n):
            c=s[i]
            #If the current character is numeric, we will mulptily that with 10 and we will add that to the curr value
            if(c.isnumeric()):
                curr=curr*10+int(c)
            #If the value of c is not numeric and if c is not equal to space or if i reached end of the string
            if((not c.isnumeric() and c!=" ") or i==n-1):
                #Based on the lastsign following operations will be performed
                if(lastSign=="+"):
                    calc+=curr
                    tail=curr
                elif(lastSign=="-"):
                    calc-=curr
                    tail=-1*curr
                elif(lastSign=="*"):
                    #The below formulae will be used to calculate the value if the lastSign is * and the tail
                    calc=calc-tail+(tail*curr)
                    tail=tail*curr 
                else:
                    #To handle negative cases, two seperate conditions are written
                    if(tail<0):
                        t=tail*-1
                        t=t//curr
                        t=t*-1
                        calc=calc-tail+t
                        tail=t
                    else:
                        #The below formulae will be used to calculate the value if the lastSign is / and the tail
                        calc=calc-tail+(tail//curr)
                        tail=tail//curr
                #we will update the lastSign and curr value, when we encounter a new sign 
                lastSign=c
                curr=0
        #Finally we are returning the calcuated value
        return calc
