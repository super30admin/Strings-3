#Time complexity is: O(1)
#Space complexity is: O(1)
#Code ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        #Initializing the required arrays with associated values which are unique
        self.below_20=["","One","Two","Three","Four","Five",
                "Six","Seven","Eight","Nine","Ten","Eleven",
                "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                "Eighteen","Nineteen"]
        self.tens=["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        thousands=["","Thousand","Million","Billion"]
        #if number is equal to zero, we will return zero
        if(num==0):
            return "Zero"
        result=""
        i=0
        while(num>0):
            #First we will take the intial three digit number
            triplet=num%1000
            if(triplet!=0):
                #We will call the helper function to find the english equivalent for the number and we will append that for the result
                result=strip(self.helper(triplet))+" "+thousands[i]+" "+result
            i+=1
            #Next we will divide the number with 1000
            num=num//1000
        #We will return the final result
        return strip(result)
    
    def helper(self,num):
        #If the number if less than 20, we will search in below_20 array
        if(num<20):
            return self.below_20[num]
        #If the number if less than 100 and greater than 19, we will find ehglish equivalent by recursively calling helper function
        elif(num<100):
            return self.tens[num//10]+" "+self.helper(num%10)
        else:
            #We will return the final accumulated english value
            return self.below_20[num//100]+" Hundred "+self.helper(num%100)

        

