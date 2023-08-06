"""
Problem : 1

Time Complexity : O(1)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Integer to English Words

class Solution(object):
    def __init__(self):

        self.below_20=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.tens=["","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.thousands=["","Thousand","Million","Billion"]
        
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if not num:
            return "Zero"
        result=""
        i=0 # suffix index
        while num>0:
            triplet=num%1000
            if triplet!=0:
                result=self.helper(triplet).strip()+" "+self.thousands[i]+" "+result
            i+=1
            num=num/1000
        return result.strip()
    
    def helper(self,num):
        if num<20:
            return self.below_20[num]
        elif num<100:
            return self.tens[num/10]+" "+self.helper(num%10)
        else:
            return self.below_20[num/100]+" Hundred "+self.helper(num%100)