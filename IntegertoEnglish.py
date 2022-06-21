#Time Complexity: O(1)
#Space Complexity: O(1)
class Solution:
    def numberToWords(self, num: int) -> str:
        self.belowTwentys = ['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        
        self.tens = ['','Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        self.thousands = ['','Thousand','Million','Billion']
        result = ""
        i = 0
        if num == 0:
            return "Zero"
    
        while num >0:
            if num%1000 != 0:
                result = self.helper(num%1000) +  self.thousands[i] + " " + result
            num = int(num/1000)
            i += 1   

            
            
        return result.strip()
    
    def helper(self,num):
        
        if num == 0:
            return ""
        
        elif num<20:
            return self.belowTwentys[num] + " "
            
        elif num<100:
            return self.tens[int(num/10)] + " " + self.helper(int(num%10))
        else:
            return self.belowTwentys[int(num/100)] + " Hundred " + self.helper(num%100)
                
                
            