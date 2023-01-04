"""
FAANMG Problem #100 {Hard } 

273. Integer to English Words

Time Complexity O(1)
Space Complexity:  O(1)
        
Did this code successfully run on Leetcode : Yes



@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def numberToWords(self, num: int) -> str:
        
        # make list of unique words that can be used to make the English words for numbers
        self.Tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        self.Below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        wording = ["", "Thousand", "Million", "Billion"]

        # if number is zero, then return it's String
        if num == 0:
            return "Zero"
        
        
        i = 0 # to maintain the triplets value
        res = ''

        # traversing while num is greater than 0
        while num > 0:
            # if 1000 mod of num is not 0, then recursively call the helper with 3 digits
            # and append the value from wordings to the res
            if num%1000 != 0:
                res = self.helper(num%1000) + wording[i] + ' ' + res
            # update num after removing 3 digits
            num = num//1000
            i+=1
        # remove extra spaces from the end of res
        return res.strip()

    def helper(self, number):
        # if we have number as 0, add space
        if number == 0:
            return ''
        
        # if number is less than 10, simply lookup in the list and return
        if number < 20:
            return self.Below_20[number] + ' '
        
        # if number is less than 100, simply lookup in the list and return with num%10
        if number < 100:
            return self.Tens[number//10] + ' '+ self.helper(number%10)
        
        else:
            # if number is greater than 100, simply lookup in the list and return with num%10
            return self.Below_20[number//100] + ' Hundred ' + self.helper(number%100)        