#Time : O(n)
#Space : O(n)
class Solution:
    below_20=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        
    tens=["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        
    thousands=["","Thousand ","Million ","Billion "]
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
         
        res=""
        p=0
        
        while num>0:
            if num%1000:
                res=self.helper(num%1000) + self.thousands[p] + res

            num=num//1000
            p+=1

        return res.strip()
    
    def helper(self,num):
        
        if num==0:
            return ""
           
        if num<20:
            return self.below_20[num]+" "
        
        elif num<100:
            return self.tens[num//10] + " "+self.helper(num%10)
        
        else:
            return self.below_20[num//100] +" Hundred "+ self.helper(num%100)