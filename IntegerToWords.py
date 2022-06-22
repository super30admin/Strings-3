#Time complexity: O(1)
#Space complexity: O(1)
class Solution:
    thousands=["","Thousand","Million","Billion"]
    tens=["",'Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
    ones=["",'One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
    def numberToWords(self, num: int) -> str:
        if num==0:
            return "Zero"
        i=0
        res=""
        while num >0:
            rem=num%1000
            if rem!=0:
                res=self.helper(rem).rstrip()+" "+self.thousands[i] + " "+res
            num=num//1000
            i+=1
        return res.strip()
    
    def helper(self,num):
        if num >= 100:
            temp=num//100
            res=self.ones[temp] + " Hundred "+ self.helper(num%100)
        elif num>=20:
            res=self.tens[num//10] +" "+self.helper(num%10)
        elif num<20:
            res=self.ones[num]
        return res
            
            
        