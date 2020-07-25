# time compexity - O(1) # string divided into triplets (max triplets=4) # creating suffix
# space complexity - O(1)
# Were you able to solve this on leetcode: yes
# any issues faced: yes, it was difficult to understand where to add the space.
class Solution:
    def numberToWords(self, num: int) -> str:
        if num==0: return "Zero"
        self.below_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        self.tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy',  'Eighty', 'Ninety']
        self.thousands = ['', 'Thousand', 'Million', 'Billion']
         
        result = ""
        i=0
        while (num>0):
            if num%1000!=0:
                result = self.suffix(num%1000) + self.thousands[i] + " " + result
            num = num//1000
            i+=1
        return result.strip()
        
        
    def suffix(self, num):
        if num==0:
            return "" # so that no extra spaces is added to the end.
        elif num<20:
            return self.below_20[num] + " "
        elif num<100:
            return self.tens[num//10] + " " + self.suffix(num%10)
        elif num<1000:
            return self.below_20[num//100] + " Hundred " + self.suffix(num%100) 
        