'''
Solution:
1.  Maintain some standard words for the base values in arrays.
2.  Perform computations on 3 digits at a time and add the words accordingly.
3.  It doesn't take more than 5 function calls where each function call will be completed
    in O(1) time

Time Complexity:    O(1)    |   Space Complexity:   O(1) -- only two fixed sized arrays required.

--- Passed all testcases successfully on Leetcode
'''


class NumberToWords:
    
    def __init__(self):

        #   global initializations
        
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        self.tens = ["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
    def __helper(self, num):

        #   case 1 -- number less than 20        
        if (num < 20):
            return [self.below_20[num]]
        
        #   case 2 -- number >= 20 and number < 100
        if (num < 100):
            return [self.tens[int(num / 10)], ' ', self.below_20[num % 10]]
        
        #   case 3 -- number between 100 and 1000
        subResult = [self.below_20[int(num / 100)], ' ', 'Hundred', ' ']
        subResult.extend(self.__helper(num%100))
        return subResult
    
    def numberToWords(self, num: int) -> str:
        
        #   base case
        if (num == 0):
            return 'Zero'
        
        resultList = []
        
        #   case 1 -- check for the presence of number > 1 Billion
        if (int(num / 1000000000) > 0):
            resultList.extend(self.__helper(int(num / 1000000000)))
            resultList.extend([' ', 'Billion', ' '])
        num = num % 1000000000
        
        #   case 2 -- check for the presence of number > 1 Million
        if (int(num / 1000000) > 0):
            resultList.extend(self.__helper(int(num / 1000000)))
            resultList.extend([' ', 'Million', ' '])
        num = num % 1000000
        
        #   case 3 -- check for the presence of number > 1 Thousand
        if (int(num / 1000) > 0):
            resultList.extend(self.__helper(int(num / 1000)))
            resultList.extend([' ', 'Thousand', ' '])
        num = num % 1000
        
        #   case 4 -- on remaining 3 digits
        resultList.extend(self.__helper(num))
        
        #   return the result
        unstripped = ''.join(resultList)
        return ' '.join(unstripped.split())