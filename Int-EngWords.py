# Time complexity : O(1)
# Space complexity : O(1)


class Solution:
    def numberToWords(self, num: int) -> str:

        self.Tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.Below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        wording = ["", "Thousand", "Million", "Billion"]


        if num == 0:
            return "Zero"
        i = 0 
        res = ''

        while num > 0:
            if num%1000 != 0:
                res = self.helper(num%1000) + wording[i] + ' ' + res
            num = num//1000
            i+=1
        return res.strip()

    def helper(self, number):
        if number == 0:
            return ''
        if number < 20:
            return self.Below_20[number] + ' '
        if number < 100:
            return self.Tens[number//10] + ' '+ self.helper(number%10)
        else:
            return self.Below_20[number//100] + ' Hundred ' + self.helper(number%100)
