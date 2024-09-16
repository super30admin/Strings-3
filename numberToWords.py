#Time Complexity:O(n)
#Space Complexity:O(1)
#Ran successfully on Leetcode:Yes
#Algo:
#this function divide number into smaller part and call helper for smaller number result is appended after every call ansd returned.

class Solution:
    def __init__(self):
        self.lessThan20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.thousands = ["","Thousand","Million","Billion"]

    def numberToWords(self, num):
        if num == 0:
            return "Zero"
        res = ""
#loop till all number is processed, total digit is divided into subpart of 3 digit
        for i in range(len(self.thousands)):
            if num % 1000 != 0:
                res = self.helper(num%1000) + self.thousands[i] + " " + res
            num //= 1000
        return res.strip()
# helper function for the driver function, it convert 3 digit or lesser  to word.
    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.lessThan20[num] + " "
        elif num < 100:
            return self.tens[num//10] + " " + self.helper(num%10)
        else:
            return self.lessThan20[num//100] + " Hundred " + self.helper(num%100)
        
