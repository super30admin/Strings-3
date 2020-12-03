#Time Complexity : O(n) where n is the length of the input string
#Space Complexity : O(n) where n is the length of the input string
#Did this code successfully run on Leetcode : Yes

class Solution:
    def __init__(self):
        self.upto20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.thousands = ["","Thousand","Million","Billion"]

    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.upto20[num] + " "
        elif num < 100:
            return self.tens[num//10] + " " + self.helper(num%10)
        else:
            return self.upto20[num//100] + " Hundred " + self.helper(num%100)

    def numberToWords(self, num: int) -> str:
        if num == 0: return "Zero"
        result = ""
        for i in range(len(self.thousands)):
            if num % 1000 != 0:
                result = self.helper(num%1000) + self.thousands[i] + " " + result
            num //= 1000
        return result.strip()
