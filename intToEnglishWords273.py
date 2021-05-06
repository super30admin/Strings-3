# TC - O(1)
# SC - O(1)

class Solution:
    def __helper(self, num: int) -> str:
        if num == 0:
            return ""
        elif num < 20:
            #print(num)
            temp = self.below_20[num]
            #print(temp, temp)
            return temp
        elif num < 100:
            return self.tens[int(num / 10)] + self.__helper(num % 10)
        else:
            return self.below_20[int(num /  100)] + "Hundred " + self.__helper(num % 100)
    
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        self.below_20 = ["", "One ", "Two ", "Three ", "Four ", "Five ","Six ", "Seven ", "Eight ", "Nine ", "Ten ", 
                         "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "]
        self.tens = ["", "Ten " , "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "]
        self.thousands = ["", "Thousand ", "Million ", "Billion "]
        
        result = ""
        i = 0
        while( num > 0):
            if num % 1000  != 0:
                result = self.__helper(num % 1000) + self.thousands[i] + result
                
            i += 1
            num = num//1000 
            
        return result.rstrip()
    