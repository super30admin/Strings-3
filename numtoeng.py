#As taught in class, using arrays and simple math to solve the problem
#Time Complexity :O(n)
#Space complexity: O(3n)
class Solution:
    def __init__(self):
        self.below_20 =["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.thousands = ["","Thousand","Million","Billion"]
    def numberToWords(self, num):
        result = ""
        i = 0
        while num > 0:
            if num != 0:
                result = self.helper(num % 1000) + self.thousands[i] + " " + result
                num = int(num / 1000)
                i = i + 1
        return result
    
    def helper(self,num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below_20[int(num)]+ " "
        elif num < 100:
            return self.tens[int(num/10)]+ " " + self.helper(num%10)
        else:
            self.below_20[int(num/100)] + "Hundred" + self.helper(num%100)

s = Solution()
r = s.numberToWords(1050)
print(r)