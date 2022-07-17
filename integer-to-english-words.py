# Time Complexity: O(1)
# Space Complexity: O(1)
class Solution:
    def numberToWords(self, num: int) -> str:
        if num==0: return "Zero"
        thousands=["","Thousand","Million","Billion"]
        ones=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens=["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        result=""
        i=0
        #356
        def helper(num):
            if num==0: return ""
            elif num>=100: return ones[num//100]+" Hundred "+helper(num%100)
            elif 20<=num<100: return tens[num//10]+" "+helper(num%10)
            elif num<20: return ones[num]+" "
             
        while num>0:#354,258
            if num%1000!=0:
                out=helper(num%1000)
                result=out+thousands[i]+" "+result
            num=num//1000
            i+=1
        return result.strip()
            
        