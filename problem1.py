#Time Complexity : O(log(num))
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes

class Solution:
    below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
                    "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
    tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
    thousand = ["","Thousand","Million","Billion"]

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        result = ""
        i = 0
        while num != 0:
            triplet = num%1000
            if triplet != 0:
                result = self.helper_counting_num(triplet).strip() + " " + self.thousand[i] + " " + result
            num = num//1000
            i += 1
        
        return result.strip()

    def helper_counting_num(self, num):
        if num < 20:
            return self.below_20[num]
        elif num < 100:
            return self.tens[num//10] + " " + self.helper_counting_num(num%10)
        else:
            return self.below_20[num // 100] + " Hundred " + self.helper_counting_num(num % 100)
