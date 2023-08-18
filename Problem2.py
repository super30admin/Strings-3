# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
class Solution:
    def numberToWords(self, num: int) -> str:
        if num==0:
            return "Zero"
        self.below_20=['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        self.tens=['','','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        self.thousands=['','Thousand','Million','Billion']
        i=0
        result=""
        while num>0:
            triplet=int(num%1000)
            if triplet!=0:
                result=self.helper(triplet).strip()+" "+self.thousands[i]+" "+result
            i+=1
            num=int(num/1000)
        return result.strip()

    def helper(self,num):
        if num<20:
            return self.below_20[num]
        elif num<100:
            return self.tens[int(num/10)]+" "+self.helper(num%10)
        else:
            return self.below_20[int(num/100)] + " Hundred "+ self.helper(int(num%100))