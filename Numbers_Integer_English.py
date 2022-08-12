class Solution:
    def numberToWords(self, num: int) -> str:
        below_twenty=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens=["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        thousands=["","Thousand","Million","Billion"]
        
        i=0
        result=""
        
        if num==0:
            return "Zero"
        
        def helper(num):
            if num==0:
                return ""
            
            elif num<20:
                return below_twenty[num]+" "
            
            elif num<100:
                return tens[num//10]+" "+ helper(num%10)
            
            else:
                return below_twenty[num//100]+ " Hundred " + helper(num%100)
        
        while num>0:
            if num%1000!=0:
                result=helper(num%1000)+thousands[i]+" "+result
                
            num//=1000
            i+=1
            
        return result.strip()
    
        