"""
273. Integer to English Words
Time Complexity - O(n)
Space Complexity - O(n)
Here we are dividing number to three parts starting from using thousand list we will be adding suffix as per division last three digits then 3 digits before that and so on.
Then again divide those 3 digits in hundred,tens and units with help of below_20 and hundred we can built new string
"""
class Solution:
    def numberToWords(self, num: int) -> str:
        below_20=["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        hundred = ["","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        thousand = ["","Thousand","Million","Billion"]
        if num == 0:
            return "Zero"
        i = 0
        String_word = ""
        while(num > 0):
            if num % 1000 != 0:
                String_word = self.recurr(num%1000, below_20, hundred) + thousand[i] +" " + String_word
            i += 1
            num = num//1000
        return String_word.strip()
            
        
    def recurr(self,num,below_20, hundred):
        if num == 0:
            return ""
        elif num < 20:
            return below_20[num] + " "
        elif num < 100:
            return hundred[num//10] + " " + self.recurr(num%10,below_20, hundred)
        elif num >= 100:
            return below_20[num//100] + " " + "Hundred" + " " + self.recurr(num%100,below_20, hundred)