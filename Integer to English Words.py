# Time:- O(n)
# Space:- O(1)
# Approach:- We need to process the number in triplets and then process the individual triplet. 
class Solution:
    def numberToWords(self, num: int) -> str:
        def helper(num):
            if num==0:
                return ""
            elif num<20:
                return below_20[num]+ " "
            elif num<100:
                return tens[num//10]+  " "+ helper(num%10)
            else:
                return below_20[num//100]+" "+ "Hundred"+ " "+helper(num%100)
            
        below_20=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens=["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        thousands=["","Thousand","Million","Billion"]
        res=""
        i=0
        if num==0:
            return "Zero"
        while(num>0):
            if num%1000!=0:
                res=helper(num%1000)+thousands[i]+" "+ res;
            num//=1000
            i+=1
        return res.strip()
        
        