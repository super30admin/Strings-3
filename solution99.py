#Time Complexity:O(1)
#Space Complexity:O(1)

#approach: Create lists of strings for below 20 , tens and thousands. Process the number in triplets backwards and append appropriate strings using % and /
class Solution:
    below_20=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
    tens=["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
    thousands=["","Thousand","Million","Billion"]
    def numberToWords(self, num: int) -> str:
        if num==0:
            return "Zero"
        result=''
        i=0
        while num>0:
            if num%1000!=0:
                result=self.helper(num%1000)+self.thousands[i]+" "+result
            num=num//1000
            i+=1
        return result.rstrip()
            
    def helper(self,num:int)->str:
        if num==0:
            return ""
        elif num<20:
            return self.below_20[num]+" "
        elif num<100:
            return self.tens[num//10]+" "+self.helper(num%10)
        else:
            return self.below_20[num//100]+" "+"Hundred"+" "+self.helper(num%100)