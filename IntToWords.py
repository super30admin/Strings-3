class Solution:
    
    """
    Description: convert a non-negative integer num to it's english words representation (US english)
    
    Time Complexity: O(1)
    Space Complexity: O(1)
    
    Approach:
    1. using the given nature of US english vocabulary create the following in form of lists:
        - words for every 1000th part (like thousand, million etc)
        - words below number 20 (all distinct words)
        - words for tens (thirty, forty etc for number below 100)
    2. use first item of above strings as empty string, so one can use the index in the list directly to find the relative text 
    3. write a helper function (after identifying the repeatation of words below 1000 in a familiar pattern, where text can be added before for million, billion etc)
    4. use the information in #3 (every 1000th division), call the function in #3 recursively to add words with appropriate amount of spaces
    """
    
    def numberToWords(self, num: int) -> str:
               
        # start with an empty string
        result = ""
        
        # words to be used 
        self.words_thousands = ["", "Thousand", "Million", "Billion"] 
        self.words_below20 = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
                         "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
                         "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.words_below100 =  ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", 
                           "Sixty", "Seventy", "Eighty", "Ninety"]
    
        if num == 0: return "Zero" # edge case
        
        def helper(num):
            if num == 0: return "" # for numbers ending at 0
            elif num < 20: return self.words_below20[num] + " "
            elif num < 100: return self.words_below100[num // 10] + " " + helper(num % 10) 
            else: return self.words_below20[num // 100] + " " + "Hundred" + " " + helper(num % 100)
        
        # Repeating stuff every 1000th part
        i = 0
        while num > 0:
            if num % 1000 != 0:
                result = helper(num % 1000) + self.words_thousands[i] + " " + result
            num = num // 1000
            i += 1
        return result.strip()
