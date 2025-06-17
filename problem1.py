#Time : O(1)
#Space : O(1)
class Solution:
    def __init__(self):
        self.below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.below_100 = ["","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
    def numberToWords(self, num: int) -> str:
        if num==0:
            return "Zero"
        thousands = ["","Thousand","Million","Billion"]
        result = ""
        i = 0
        while num>0:
            if num%1000 != 0:
                result = self.helper(num%1000)+thousands[i]+" "+result
            i+=1
            num = num//1000
        return result.strip()
    def helper(self,n):
        if n==0:
            return ""
        elif n<20:
            return self.below_20[n]+" "
        elif n<100:
            return self.below_100[n//10] + " " + self.helper(n%10)
        else:
            return self.below_20[n//100]+ " "+"Hundred"+" "+self.helper(n%100)
