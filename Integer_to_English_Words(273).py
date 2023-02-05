# Time Complexity: O(1) because length of number is already capped
# Space Complexity: O(1)

class Solution:
    def __init__(self):
        self.thousands = ["","Thousand","Million","Billion"]
        self.below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
        "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        self.tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]

    def numberToWords(self, num: int) -> str:
        if num==0:
            return "Zero"
        idx = 0
        res = ""

        # we process 3 numbers of a thousand batch in an iteration
        while num>0:
            if num%1000!=0:
                res = self.helper(num%1000) + self.thousands[idx] + " " + res
            idx+=1
            num = num//1000

        return res.rstrip()

    def helper(self,num):
        if num==0:
            return ""
        if num<20:
            return self.below_20[num] + " "
        elif num<100:
            return self.tens[num//10] + " " + self.helper(num%10)
        else:
            return self.below_20[num//100] + " Hundred " + self.helper(num%100)