below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]

tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]

thousands = ["", "Thousand","Million","Billion"]

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        i = 0
        result = ""
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num % 1000)+ thousands[i]+" "+result
            i += 1
            num = num // 1000
        return result.rstrip()

    def helper(self,num):
        if num == 0: return ""
        if num < 20:
            return below_20[num]+" "
        elif num < 100:
            return tens[num//10]+" "+self.helper(num  % 10)
        else:
            return below_20[num // 100]+" "+"Hundred"+" "+self.helper(num%100)
            
        