# Time: O(1) as max triplets can be three each triplets goes through the helper four times so O(12)
# Space: O(1)

class Solution:
    def numberToWords(self, num: int) -> str:
        
        self.below_20 = ['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        self.tens = ['','Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        self.thousands = ['','Thousand','Million','Billion']
        
        if num == 0:
            return 'Zero'
        
        # getting triplets from the number
        result = ''
        i = 0 # pointer on thousands array
        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num%1000) + self.thousands[i] + ' ' + result 
            i += 1
            num = int(num/1000)
        return result.strip()
    
    def helper(self, num):
        if num == 0:
            return ''
        elif num < 20:
            return self.below_20[num] + ' '
        elif num < 100:
            return self.tens[int(num/10)] + ' ' + self.helper(int(num % 10))
        else:
            return self.below_20[int(num/100)] + ' Hundred ' + self.helper(num % 100) 
        