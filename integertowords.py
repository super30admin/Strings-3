#TC: O(1)
#SC: O(1)

class NumberToWords:
    
    def __init__(self):
        
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        self.tens = ["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
    def __helper(self, num):
      
        if (num < 20):
            return [self.below_20[num]]
        
        if (num < 100):
            return [self.tens[int(num / 10)], ' ', self.below_20[num % 10]]
        
        subResult = [self.below_20[int(num / 100)], ' ', 'Hundred', ' ']
        subResult.extend(self.__helper(num%100))
        return subResult
    
    def numberToWords(self, num: int) -> str:
        
        if (num == 0):
            return 'Zero'
        
        resultList = []
        
        if (int(num / 1000000000) > 0):
            resultList.extend(self.__helper(int(num / 1000000000)))
            resultList.extend([' ', 'Billion', ' '])
        num = num % 1000000000
        
        if (int(num / 1000000) > 0):
            resultList.extend(self.__helper(int(num / 1000000)))
            resultList.extend([' ', 'Million', ' '])
        num = num % 1000000
        
        if (int(num / 1000) > 0):
            resultList.extend(self.__helper(int(num / 1000)))
            resultList.extend([' ', 'Thousand', ' '])
        num = num % 1000
        
        resultList.extend(self.__helper(num))
        
        unstripped = ''.join(resultList)
        return ' '.join(unstripped.split())