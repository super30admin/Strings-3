'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve", "Thirteen","Fourteen","Fifteen","Sixteen", "Seventeen","Eighteen","Nineteen"]
    tens = ["", "Ten","Twenty","Thirty", "Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
    thousand = ["","Thousand","Million","Billion"]
    
    def numberToWords(self, num: int) -> str:
        
        i = 0
        ans = ""
        if(num==0): return "Zero"
        while(num!=0):
            if(num%1000!=0):
                ans = self.helper(num%1000) + self.thousand[i]+" " + ans
            i+=1
            num=num//1000
        return ans.strip()
    def helper(self,num):
        
        if(num==0): return ""
        elif(num<20):
            return self.below_20[num] + " "
        elif(num<100):
            return self.tens[num//10] + " " + self.helper(num%10)
        else:
            return self.below_20[num//100] + " Hundred " + self.helper(num%100)
        