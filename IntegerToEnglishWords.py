# TC: O(1), constant time, as we will be calling the helper function for the number of triplets in the input string, which is constant. 
# SC: O(1), as we do not use any extra space. The space used for storing the below_20, tens and thousands is also constant.

class Solution:
    def numberToWords(self, num: int) -> str:
        
        self.below_20 = [" ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "]
        
        self.tens = [" ", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "]
        
        self.thousands = [" ", "Thousand ", "Million ", "Billion "]
        
        if num == 0: 
            return "Zero"
        
        i = 0
        result = ""
        while num > 0: 
            if num % 1000 != 0: 
                result = self.helper(num % 1000) + self.thousands[i] + result
            num = num // 1000 
            i += 1
        return result.strip()
    
    def helper(self, num): 
        if num == 0: 
            return ""
        
        elif num < 20: 
            return self.below_20[num]
        
        elif num < 100: 
            return self.tens[num // 10] + self.helper(num % 10)
        
        else: 
            return self.below_20[num // 100] + "Hundred " + self.helper(num % 100)
