"""
Runtime Complexity: O(1) - we divide and check modulo to process only triplets of a number and we only go traverse through a fixed size of lists. Therefore its constant.
Space Complexity: O(1) -  we have 3 lists and they are of fixed size, therefore the space complexity is constant.
Yes, the code worked on leetcode.
Issues while coding-No
"""


class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        thousands = ["","Thousand","Million","Billion"]
        result = ""
        i = 0
        
        while(num>0):
            if num % 1000!=0:
                result = self.helper(num%1000)+thousands[i]+" "+result
            num = num//1000
            i+=1
        return result.strip()
    
    def helper(self,num):
        below_20 = ["","One", "Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"] 
    
        if num == 0:
            return ""
        elif num<20:
            return below_20[num]+" "
        elif num<100:
            return tens[num//10]+ " "+self.helper(num%10)
        else:
            return below_20[num//100] + " Hundred " + self.helper(num%100)
        
        
        